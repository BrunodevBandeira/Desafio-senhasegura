package br.com.senhasegura.service;

import org.springframework.stereotype.Service;

import br.com.senhasegura.entity.DTO.PasswordRequestDTO;
import br.com.senhasegura.entity.DTO.PasswordResponseDTO;
@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public PasswordResponseDTO sendPassword(PasswordRequestDTO passwordRequestDTO) {
        String getPassword = passwordRequestDTO.getPasswordSecurity();
        System.out.println("=> " + getPassword);
        if (getPassword == null) {
            return new PasswordResponseDTO("veio como null");
        }
        boolean hasMinLength = getPassword.length() >= 8;
        boolean hasUpperCase = getPassword.equals(getPassword.toUpperCase());
        boolean hasLowerCase = getPassword.equals(getPassword.toLowerCase());
        String specialCharacters = "!@#$%^&*()-_=+[{]};:',<.>/?";

        boolean hasDigit = false;
        for(char c : getPassword.toCharArray()) {
            if(Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }

        boolean hasSpecialCharacter = false;
        for (char c : getPassword.toCharArray()) {
            if (specialCharacters.contains(String.valueOf(c))) {
                hasSpecialCharacter = true;
                break;
            }
        }

        System.out.println("=> 01 " + hasMinLength);
        System.out.println("=> 02 " + hasUpperCase);
        System.out.println("=> 03 " + hasLowerCase);
        System.out.println("=> 04 " + hasDigit);
        System.out.println("=> 05 " + hasSpecialCharacter);

        if(hasMinLength && hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter) {
            System.out.println("positivo");
            return new PasswordResponseDTO("positivo");
        } else {
            System.out.println("negativo");
            return new PasswordResponseDTO("negativo");
        }


    }
    
}
