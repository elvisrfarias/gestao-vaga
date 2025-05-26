package br.com.elvisfarias.main.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(example = "Vaga para desenvolvedor java", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;
    @Schema(example = "Plano de saúde, VR, GYMPass", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefits;
    @Schema(example = "Pleno", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;
}
