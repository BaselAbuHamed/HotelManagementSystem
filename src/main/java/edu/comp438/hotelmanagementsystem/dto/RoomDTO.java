package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO extends RepresentationModel<RoomDTO> {

    private Long id;

    @NotNull(message = "Floor ID is mandatory")
    private Long floorId;

    @NotNull(message = "Room class ID is mandatory")
    private Long roomClassId;

    @NotNull(message = "Status ID is mandatory")
    private Long statusId;

    @NotBlank(message = "Room number is mandatory")
    private String roomNumber;
}
