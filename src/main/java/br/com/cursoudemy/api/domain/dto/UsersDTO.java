package br.com.cursoudemy.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UsersDTO {
    @Setter @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    private Integer id;
    private String name;
    private String email;
    private String password;
}
