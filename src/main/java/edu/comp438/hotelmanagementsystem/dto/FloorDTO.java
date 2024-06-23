package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FloorDTO {

    private Long id;

    @NotNull(message = "Floor number is mandatory")
    private Integer floorNumber;
}
