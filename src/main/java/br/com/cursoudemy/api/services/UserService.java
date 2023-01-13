package br.com.cursoudemy.api.services;

import br.com.cursoudemy.api.domain.Users;

public interface UserService {

    Users findById(Integer id);
}
