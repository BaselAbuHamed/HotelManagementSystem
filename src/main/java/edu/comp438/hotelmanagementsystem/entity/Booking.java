package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Customer ID is mandatory")
    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Customer customer;

    @NotNull(message = "Check-in date is mandatory")
    @Column(name = "checkin_date", nullable = false)
    private LocalDate checkinDate;

    @NotNull(message = "Check-out date is mandatory")
    @Column(name = "checkout_date", nullable = false)
    private LocalDate checkoutDate;

    @Min(value = 1, message = "Number of adults must be at least 1")
    @Column(name = "num_adults", nullable = false)
    private int numAdults;

    @Min(value = 0, message = "Number of children cannot be negative")
    @Column(name = "num_children", nullable = false)
    private int numChildren;

    @NotNull(message = "Booking amount is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Booking amount must be greater than zero")
    @Column(name = "booking_amount", nullable = false)
    private BigDecimal bookingAmount;

    @NotNull(message = "Payment status ID is mandatory")
    @ManyToOne
    @JoinColumn(name = "payment_status_id", nullable = false)
    private PaymentStatus paymentStatus;
}
