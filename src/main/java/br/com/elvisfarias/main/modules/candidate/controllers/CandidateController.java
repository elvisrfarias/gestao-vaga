package br.com.elvisfarias.main.modules.candidate.controllers;

import br.com.elvisfarias.main.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.elvisfarias.main.modules.candidate.entities.CandidateEntity;
import br.com.elvisfarias.main.modules.candidate.useCases.CreateCandidateUseCase;
import br.com.elvisfarias.main.modules.candidate.useCases.ListAllJobsByFilterUseCase;
import br.com.elvisfarias.main.modules.candidate.useCases.ProfileCandidateUseCase;
import br.com.elvisfarias.main.modules.company.entities.JobEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/candidate")
@Tag(name = "Candidato", description = "Rotas dedicadas para candidatos")
@SecurityRequirement(name = "jwt_auth")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private ListAllJobsByFilterUseCase listAllJobsByFilterUseCase;

    @PostMapping
    @Operation(description = "Essa rota será usada para cadastro de dados.")
    @ApiResponse(responseCode = "200", description = "Retorna todos os jobs de um candidato", content = {
            @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
    })
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    @PreAuthorize("hasRole('CANDIDATE')")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = ProfileCandidateResponseDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "User not found")
    })
    public ResponseEntity<Object> read(HttpServletRequest request) {
        var idCandidate = request.getAttribute("candidate_id");

        try {
            var result = profileCandidateUseCase.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    @ApiResponse(responseCode = "200", description = "Retorna todos os jobs de um candidato", content = {
            @Content(array = @ArraySchema(schema = @Schema(implementation = JobEntity.class)))
    })
    public List<JobEntity> readJobByFilter(@RequestParam String filter) {
        return this.listAllJobsByFilterUseCase.execute(filter);
    }
}
