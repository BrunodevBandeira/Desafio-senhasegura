package br.com.senhasegura.service;

import org.springframework.stereotype.Service;

import br.com.senhasegura.entity.DTO.PasswordRequestDTO;
import br.com.senhasegura.entity.DTO.PasswordResponseDTO;


public interface PasswordService {
    
    PasswordResponseDTO sendPassword(PasswordRequestDTO passwordRequestDTO);
}
