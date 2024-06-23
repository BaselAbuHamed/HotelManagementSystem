package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HousekeepingDTO {

    private Long id;

    @NotNull(message = "Room ID is mandatory")
    private Long roomId;

    @NotNull(message = "Employee ID is mandatory")
    private Long employeeId;

    @NotNull(message = "Task date is mandatory")
    private LocalDate taskDate;

    @NotBlank(message = "Task description is mandatory")
    private String taskDescription;

    @NotBlank(message = "Status is mandatory")
    private String status;
}
