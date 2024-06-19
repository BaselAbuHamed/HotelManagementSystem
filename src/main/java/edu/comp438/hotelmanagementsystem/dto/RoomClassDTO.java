package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassDTO extends RepresentationModel<RoomClassDTO> {

    private Long id;

    @NotBlank(message = "Class name is mandatory")
    private String className;

    @NotNull(message = "Base price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Base price must be greater than zero")
    private BigDecimal basePrice;
}
