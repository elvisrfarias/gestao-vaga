package br.com.elvisfarias.main.modules.candidate.useCases;


import br.com.elvisfarias.main.exceptions.JobNotFoundException;
import br.com.elvisfarias.main.exceptions.UserNotFoundException;
import br.com.elvisfarias.main.modules.candidate.entities.ApplyJobEntity;
import br.com.elvisfarias.main.modules.candidate.repositoreis.ApplyJobRepository;
import br.com.elvisfarias.main.modules.candidate.repositoreis.CanditateRepository;
import br.com.elvisfarias.main.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CanditateRepository canditateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // Id candidato
    // Id vaga
    public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {

        this.canditateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        var applyJob = ApplyJobEntity.builder()
                .candidateId(idCandidate)
                .jobId(idJob)
                .build();

        applyJob = applyJobRepository.save(applyJob);

        return applyJob;
    }
}
