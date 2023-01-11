package br.com.cursoudemy.api;

import br.com.cursoudemy.api.domain.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    Users user = new Users(1,"Rachel", "email@gmail.com","123");
}
