package br.com.elvisfarias.main.modules.user.controllers;

import br.com.elvisfarias.main.modules.user.entity.UserEntity;
import br.com.elvisfarias.main.modules.user.useCase.CreateUserUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @PostMapping
    @Tag(name = "Cadastro" , description = "Rota usada para cadastros")
    public UserEntity create(@Valid @RequestBody UserEntity userEntity) {
        return this.createUserUseCase.execute(userEntity);
    }
}
