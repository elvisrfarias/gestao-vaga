package br.com.elvisfarias.main.modules.candidate.usaCases;

import br.com.elvisfarias.main.exceptions.JobNotFoundException;
import br.com.elvisfarias.main.exceptions.UserNotFoundException;
import br.com.elvisfarias.main.modules.candidate.entities.CandidateEntity;
import br.com.elvisfarias.main.modules.candidate.repositoreis.CanditateRepository;
import br.com.elvisfarias.main.modules.candidate.useCases.ApplyJobCandidateUseCase;
import br.com.elvisfarias.main.modules.company.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CanditateRepository canditateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Não deve ser possivel de aplicar em uma vaga se o candidato não for encontrado")
    public void sholdNotBeAbleToApplyIfCandidateNotFound() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    @DisplayName("Não deve ser possivel de aplicar em uma vaga se a vaga não for encontrada")
    public void sholdNotBeAbleToApplyIfJobNotFound() {
        var idCandidate = UUID.randomUUID();

        var candidate =  new CandidateEntity();
        candidate.setId(idCandidate);

        when(canditateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }
}
