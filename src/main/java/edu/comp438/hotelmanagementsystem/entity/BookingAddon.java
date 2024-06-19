package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_addon")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingAddon {

    @EmbeddedId
    private BookingAddonId id;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @MapsId("addonId")
    @JoinColumn(name = "addon_id", nullable = false)
    private Addon addon;
}
