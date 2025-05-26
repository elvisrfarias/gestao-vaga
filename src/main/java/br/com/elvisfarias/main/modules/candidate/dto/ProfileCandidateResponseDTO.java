package br.com.elvisfarias.main.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    @Schema(hidden = true)
    private UUID id;
    @Schema(example = "João Silva")
    private String name;
    @Schema(example = "joaosilva")
    private String username;
    @Schema(example = "joaosilva@gmail.com")
    private String email;
    @Schema(example = "Estou em busca de novas oportunidades para vagas em Java")
    private String description;
}
