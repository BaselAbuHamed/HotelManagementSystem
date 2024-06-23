package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassFeatureDTO {

    @NotNull(message = "Room class ID is mandatory")
    private Long roomClassId;

    @NotNull(message = "Feature ID is mandatory")
    private Long featureId;
}
