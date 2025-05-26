package br.com.elvisfarias.main.modules.company.repositories;

import br.com.elvisfarias.main.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {


    // Contains
    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
