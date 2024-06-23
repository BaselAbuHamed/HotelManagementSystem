package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    @NotNull(message = "Role ID is mandatory")
    private Long id;

    @NotNull(message = "Role name is mandatory")
    private String name;
}
