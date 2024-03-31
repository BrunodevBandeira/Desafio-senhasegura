package br.com.senhasegura.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.senhasegura.entity.Password;
import br.com.senhasegura.entity.DTO.PasswordRequestDTO;
import br.com.senhasegura.entity.DTO.PasswordResponseDTO;
import br.com.senhasegura.service.PasswordService;

@RestController
@RequestMapping("/send-password")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }
    
    @PostMapping
    public ResponseEntity<PasswordResponseDTO> sendPassword(@RequestBody PasswordRequestDTO passwordRequestDTO, UriComponentsBuilder uriBuilder) {
        PasswordResponseDTO passwordResponseDTO = passwordService.sendPassword(passwordRequestDTO);
        URI uri = uriBuilder.path("/send-password").buildAndExpand(passwordResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(passwordResponseDTO);
    }
}

