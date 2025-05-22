package br.com.elvisfarias.main.modules.company.dto;

import lombok.Data;

@Data
public class CreateJobDTO {
    private String description;
    private String benefits;
    private String level;
}
