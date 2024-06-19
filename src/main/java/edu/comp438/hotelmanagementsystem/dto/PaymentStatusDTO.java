package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatusDTO extends RepresentationModel<PaymentStatusDTO> {

    private Long id;

    @NotBlank(message = "Payment status name is mandatory")
    private String paymentStatusName;
}
