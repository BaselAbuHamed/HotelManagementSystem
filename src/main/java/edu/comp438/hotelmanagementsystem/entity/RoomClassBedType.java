package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "room_class_bed_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassBedType {

    @EmbeddedId
    private RoomClassBedTypeId id;

    @ManyToOne
    @MapsId("roomClassId")
    @JoinColumn(name = "room_class_id", nullable = false)
    private RoomClass roomClass;

    @ManyToOne
    @MapsId("bedTypeId")
    @JoinColumn(name = "bed_type_id", nullable = false)
    private BedType bedType;

    @Column(name = "num_beds", nullable = false)
    private int numBeds;
}


