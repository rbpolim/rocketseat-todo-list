package br.com.rbpolim.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Modificadores
  - public
  - protected
  - private
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired // Injeta a dependência automaticamente
  private IUserRepository userRepository;

  /*
   * string (Texto)
   * int (Número inteiro)
   * double (Número decimal)
   * boolean (Verdadeiro ou falso)
   * float (Número decimal)
   * char (Caractere)
   * date (Data)
   * void
   */

  @PostMapping("/")
  public ResponseEntity create(@RequestBody UserModel userModel) {
    var userExists = this.userRepository.findByUsername(userModel.getUsername());

    if (userExists != null) {
      return ResponseEntity.badRequest().body("User already exists");
    }

    var user = this.userRepository.save(userModel);

    return ResponseEntity.ok(user);
  }
}
