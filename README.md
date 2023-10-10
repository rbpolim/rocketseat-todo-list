# Techs

- Java
- Spring Boot
- Lombok

# Aula 2
  - Adicionou dependencia do Lombok no pom.xml (https://projectlombok.org/setup/maven) 

  ```
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
  </dependency>
  ```

 - Adicionado o decorator @Data na classe de modelo (User)
 - Armazenar dados Spring Data JPA (https://spring.io/guides/gs/accessing-data-jpa/) 
    - Trabalha com ORM (Object Relational Mapping)
    - Utilizaremos um banco em memoria (H2)
    - Mapeia objetos Java para tabelas do banco de dados
    - Adicionou dependencias do Spring Data JPA no pom.xml (https://spring.io/guides/gs/accessing-data-jpa/)
    ```
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
    ```

    -  Configurar o H2
      No arquivo application.properties, adicionar as seguintes linhas:
      ```
        spring.datasource.url=jdbc:h2:mem:todolist
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=admin
        spring.datasource.password=admin
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
        spring.h2.console.enabled=true
      ```

      - Apos rodar o servidor e acessar a URL http://localhost:8080/h2-console, 
      - deve-se configurar o campo JDBC URL com o valor jdbc:h2:mem:todolist e clicar em Connect. 
      ![image](https://github.com/rbpolim/supply-marine/assets/66570560/030237cb-fb73-4741-9d38-92a1161667f6)
      ![image](https://github.com/rbpolim/supply-marine/assets/66570560/3f4b3841-5b7f-4c86-a730-7f1e19179dc4)

 