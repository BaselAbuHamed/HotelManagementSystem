package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingAddonDTO extends RepresentationModel<BookingAddonDTO> {

    @NotNull(message = "Booking ID is mandatory")
    private Long bookingId;

    @NotNull(message = "Addon ID is mandatory")
    private Long addonId;
}
