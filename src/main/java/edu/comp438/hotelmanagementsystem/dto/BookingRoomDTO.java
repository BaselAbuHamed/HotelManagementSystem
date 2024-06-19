package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRoomDTO extends RepresentationModel<BookingRoomDTO> {

    @NotNull(message = "Booking ID is mandatory")
    private Long bookingId;

    @NotNull(message = "Room ID is mandatory")
    private Long roomId;
}
