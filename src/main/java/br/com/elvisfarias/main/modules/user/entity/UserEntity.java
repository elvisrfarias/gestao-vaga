package br.com.elvisfarias.main.modules.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "usuario")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String sobrenome;

    @Email(message = "Email inválido.")
    private String email;

    private String login;

    private String password;

    private LocalDate dataNascimento;

    @CreationTimestamp
    private LocalDateTime createAt;
}
