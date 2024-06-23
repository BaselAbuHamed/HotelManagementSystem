package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO{

    private Long id;

    @NotNull(message = "Customer ID is mandatory")
    private Long customerId;

    @NotNull(message = "Check-in date is mandatory")
    private LocalDate checkinDate;

    @NotNull(message = "Check-out date is mandatory")
    private LocalDate checkoutDate;

    @Min(value = 1, message = "Number of adults must be at least 1")
    private int numAdults;

    @Min(value = 0, message = "Number of children cannot be negative")
    private int numChildren;

    @NotNull(message = "Booking amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Booking amount must be greater than zero")
    private BigDecimal bookingAmount;

    private Long paymentStatusId;

    @NotNull(message = "Room IDs are mandatory")
    private List<Long> roomIds;
}
