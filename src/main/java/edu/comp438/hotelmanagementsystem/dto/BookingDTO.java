package edu.comp438.hotelmanagementsystem.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO extends RepresentationModel<BookingDTO> {

    private Long id;

    private Long customerId;

    @NotNull(message = "Check-in date is mandatory")
    private LocalDate checkinDate;

    @NotNull(message = "Check-out date is mandatory")
    private LocalDate checkoutDate;

    @NotNull(message = "Number of adults is mandatory")
    @Min(value = 1, message = "Number of adults must be greater than zero")
    private Integer numAdults;

    @NotNull(message = "Number of children is mandatory")
    @Min(value = 0, message = "Number of children must be greater than or equal to zero")
    private Integer numChildren;

    @NotNull(message = "Booking amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Booking amount must be greater than zero")
    private BigDecimal bookingAmount;

    private Long paymentStatusId;
}
