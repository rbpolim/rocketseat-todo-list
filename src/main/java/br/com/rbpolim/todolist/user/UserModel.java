package br.com.rbpolim.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data; // Importa a biblioteca Lombok

@Data // Cria automaticamente os getters e setters para os atributos da classe
@Entity(name = "tb_users") // Define o nome da tabela no banco de dados (users)
public class UserModel {

  @Id // Define o atributo como chave primária
  @GeneratedValue(generator = "UUID") // Define o tipo de geração do valor do atributo
  private UUID id; // Define o tipo do atributo como UUID

  @Column(unique = true) // Define o atributo como único
  private String username;
  private String name;
  private String password;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
