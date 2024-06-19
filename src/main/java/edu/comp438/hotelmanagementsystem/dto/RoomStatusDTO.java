package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatusDTO extends RepresentationModel<RoomStatusDTO> {

    private Long id;

    @NotBlank(message = "Status name is mandatory")
    private String statusName;
}
