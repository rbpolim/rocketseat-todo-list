package br.com.rbpolim.todolist.user;

import lombok.Data; // Importa a biblioteca Lombok

@Data // Cria automaticamente os getters e setters para os atributos da classe
public class UserModel {
  private String username;
  private String name;
  private String password;
}
