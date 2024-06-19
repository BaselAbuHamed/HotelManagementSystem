package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BedTypeDTO extends RepresentationModel<BedTypeDTO> {

    private Long id;

    @NotBlank(message = "Bed type name is mandatory")
    private String bedTypeName;
}
