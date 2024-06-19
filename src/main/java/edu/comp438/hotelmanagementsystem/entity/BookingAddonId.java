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
public class BookingAddonId implements Serializable {
    private Long bookingId;
    private Long addonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingAddonId that = (BookingAddonId) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(addonId, that.addonId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, addonId);
    }
}
