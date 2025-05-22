package br.com.elvisfarias.main.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username deve conter apenas letras e números")
    private String username;
    @Email(message = "Email inválido")
    private String email;
    @Length(min = 10, max = 100, message = "Senha deve ter entre 10 e 100 caracteres")
    private String password;

    private String website;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
