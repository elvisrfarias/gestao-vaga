package br.com.elvisfarias.main.modules.candidate.repositoreis;

import br.com.elvisfarias.main.modules.candidate.entities.ApplyJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {
}
