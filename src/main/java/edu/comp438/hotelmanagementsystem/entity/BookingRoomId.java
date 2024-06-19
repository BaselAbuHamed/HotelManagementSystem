package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRoomId implements Serializable {
    private Long bookingId;
    private Long roomId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingRoomId that = (BookingRoomId) o;
        return Objects.equals(bookingId, that.bookingId) &&
                Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, roomId);
    }
}