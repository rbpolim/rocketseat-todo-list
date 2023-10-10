package br.com.rbpolim.todolist.user;

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
  public void create(@RequestBody UserModel userModel) {
    System.out.println(userModel.getUsername());
  }
}
