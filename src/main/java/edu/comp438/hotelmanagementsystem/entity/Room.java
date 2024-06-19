package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "room")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "floor_id", nullable = false)
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "room_class_id", nullable = false)
    private RoomClass roomClass;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private RoomStatus status;

    @NotBlank(message = "Room number is mandatory")
    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;
}
