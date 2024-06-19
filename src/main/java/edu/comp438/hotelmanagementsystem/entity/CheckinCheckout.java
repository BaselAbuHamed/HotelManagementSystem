package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "checkin_checkout")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckinCheckout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @NotNull(message = "Check-in date is mandatory")
    @Column(name = "checkin_date", nullable = false)
    private LocalDate checkinDate;

    @NotNull(message = "Check-out date is mandatory")
    @Column(name = "checkout_date", nullable = false)
    private LocalDate checkoutDate;

    @Column(name = "checked_in", nullable = false)
    private boolean checkedIn;

    @Column(name = "checked_out", nullable = false)
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
