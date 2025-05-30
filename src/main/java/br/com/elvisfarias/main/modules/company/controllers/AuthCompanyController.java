package br.com.elvisfarias.main.modules.company.controllers;

import br.com.elvisfarias.main.modules.company.dto.AuthCompanyDTO;
import br.com.elvisfarias.main.modules.company.useCases.AuthCompanyUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/company")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/auth")
    @Tag(name = "Autenticação" , description = "Rota usada para autenticação")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        try{
            var result = this.authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
