package br.com.elvisfarias.main.modules.candidate.controllers;

import br.com.elvisfarias.main.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.elvisfarias.main.modules.candidate.useCases.AuthCandidateUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/auth")
    @Tag(name = "Autenticação" , description = "Rota usada para autenticação")
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateResponseDTO) {
        try{
            var token = this.authCandidateUseCase.execute(authCandidateResponseDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
