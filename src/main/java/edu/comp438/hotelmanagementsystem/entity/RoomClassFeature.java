package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "room_class_feature")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClassFeature {

    @EmbeddedId
    private RoomClassFeatureId id;

    @ManyToOne
    @MapsId("roomClassId")
    @JoinColumn(name = "room_class_id", nullable = false)
    private RoomClass roomClass;

    @ManyToOne
    @MapsId("featureId")
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;
}

