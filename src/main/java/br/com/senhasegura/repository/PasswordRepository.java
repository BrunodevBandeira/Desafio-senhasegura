package br.com.senhasegura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senhasegura.entity.Password;

public interface PasswordRepository extends JpaRepository<Password, Long>{
    
}
