package edu.comp438.hotelmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckinCheckoutDTO {

    private Long id;

    @NotNull(message = "Booking ID is mandatory")
    private Long bookingId;

    @NotNull(message = "Check-in date is mandatory")
    private LocalDate checkinDate;

    @NotNull(message = "Check-out date is mandatory")
    private LocalDate checkoutDate;

    private boolean checkedIn;
    private boolean checkedOut;

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
