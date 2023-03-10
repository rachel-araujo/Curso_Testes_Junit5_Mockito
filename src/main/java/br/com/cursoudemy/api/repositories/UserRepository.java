package br.com.cursoudemy.api.repositories;

import br.com.cursoudemy.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer > {

    Optional<Users> findByEmail(String email);
}
