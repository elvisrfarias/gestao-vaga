package br.com.elvisfarias.main.modules.candidate.repositoreis;

import br.com.elvisfarias.main.modules.candidate.entities.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CanditateRepository extends JpaRepository<CandidateEntity, UUID> {
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
  Optional<CandidateEntity> findByUsername(String username);
}
