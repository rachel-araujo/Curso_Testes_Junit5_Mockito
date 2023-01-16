package br.com.cursoudemy.api.services;

import br.com.cursoudemy.api.domain.Users;

import java.util.List;

public interface UserService {

    Users findById(Integer id);
    List<Users> findAll();
}
