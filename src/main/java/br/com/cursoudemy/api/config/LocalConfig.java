package br.com.cursoudemy.api.config;

import br.com.cursoudemy.api.domain.Users;
import br.com.cursoudemy.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public void startDB() {
        Users u1 = new Users(null, "Rachel", "email@gmail.com", "123");
        Users u2 = new Users(null, "Maria", "maria@gmail.com", "456");

        repository.saveAll(List.of(u1, u2));
    }

}
