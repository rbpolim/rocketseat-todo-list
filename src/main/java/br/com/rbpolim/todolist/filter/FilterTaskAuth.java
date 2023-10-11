package br.com.rbpolim.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.rbpolim.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // Indica que a classe é um componente do Spring
public class FilterTaskAuth extends OncePerRequestFilter {
  @Autowired
  private IUserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    // Pegar a autorização do cabeçalho da requisição
    var authorization = request.getHeader("Authorization");
    System.out.println(authorization); // Basic dGVzdDp0ZXN0

    var authEncoded = authorization.substring("Basic".length()).trim();
    System.out.println(authEncoded); // dGVzdDp0ZXN0

    byte[] authDecode = Base64.getDecoder().decode(authEncoded);
    System.out.println(authDecode); // [B@1f32e575

    var authString = new String(authDecode);
    System.out.println(authString); // username:password

    String[] credentials = authString.split(":");
    var username = credentials[0];
    var password = credentials[1];

    // Validar usuário
    var user = this.userRepository.findByUsername(username);

    if (user == null) {
      response.sendError(401);
    } else {
      // Validar senha
      var verifyPassword = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword().toCharArray());

      if (!verifyPassword.verified) {
        response.sendError(401);
      }

      // Se usuário e senha estiverem corretos, continuar a requisição
      filterChain.doFilter(request, response);
    }
  }
}
