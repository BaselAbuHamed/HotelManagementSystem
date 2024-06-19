package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking_room")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRoom {

    @EmbeddedId
    private BookingRoomId id;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
}
