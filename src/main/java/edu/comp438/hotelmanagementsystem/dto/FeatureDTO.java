package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FeatureDTO {

    private Long id;

    @NotBlank(message = "Feature name is mandatory")
    private String featureName;
}
