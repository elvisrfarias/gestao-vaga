package br.com.elvisfarias.main.modules.candidate.useCases;

import br.com.elvisfarias.main.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.elvisfarias.main.modules.candidate.repositoreis.CanditateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;


public class ProfileCandidateUseCase {

    @Autowired
    private CanditateRepository canditateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.canditateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .description(candidate.getDescription())
                .build();

        return candidateDTO;
    }
}
