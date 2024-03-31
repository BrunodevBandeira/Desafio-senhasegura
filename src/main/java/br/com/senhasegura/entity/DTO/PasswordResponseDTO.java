package br.com.senhasegura.entity.DTO;

import br.com.senhasegura.entity.Password;
import lombok.Data;

@Data
public class PasswordResponseDTO {

    private Long id;
    private String passwordSecurity;

    public PasswordResponseDTO() {}

    public PasswordResponseDTO(String passwordSecurity) {
        this.passwordSecurity = passwordSecurity;
    }

    public PasswordResponseDTO(Password password) {
        this.id = password.getId();
        this.passwordSecurity = password.getPasswordSecurity();
    }
    
}
