package br.com.elvisfarias.main.modules.company.useCases;

import br.com.elvisfarias.main.modules.company.entities.JobEntity;
import br.com.elvisfarias.main.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
