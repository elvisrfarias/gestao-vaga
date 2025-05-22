package br.com.elvisfarias.main.modules.candidate.useCases;

import br.com.elvisfarias.main.exceptions.UserFoundException;
import br.com.elvisfarias.main.modules.candidate.entities.CandidateEntity;
import br.com.elvisfarias.main.modules.candidate.repositoreis.CanditateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CanditateRepository canditateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.canditateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        var password =  passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.canditateRepository.save(candidateEntity);
    }
}
