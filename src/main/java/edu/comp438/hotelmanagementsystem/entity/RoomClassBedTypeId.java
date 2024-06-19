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
public class RoomClassBedTypeId implements Serializable {
    private Long roomClassId;
    private Long bedTypeId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomClassBedTypeId that = (RoomClassBedTypeId) o;
        return Objects.equals(roomClassId, that.roomClassId) && Objects.equals(bedTypeId, that.bedTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomClassId, bedTypeId);
    }
}