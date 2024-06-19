package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassBedTypeDTO extends RepresentationModel<RoomClassBedTypeDTO> {

    @NotNull(message = "Room class ID is mandatory")
    private Long roomClassId;

    @NotNull(message = "Bed type ID is mandatory")
    private Long bedTypeId;

    @Min(value = 1, message = "Number of beds must be at least 1")
    private int numBeds;

}
