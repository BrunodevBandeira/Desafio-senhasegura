package br.com.senhasegura.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_password")
@Data
public class Password implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "passwordSecurity", nullable = false)
    private String passwordSecurity;

    public Password() {}

    public Password(String passwordSecurity) {
        this.passwordSecurity = passwordSecurity;
    }
    

}
