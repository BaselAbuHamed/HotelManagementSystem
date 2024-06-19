package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "room_status")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Status name is mandatory")
    @Column(name = "status_name", nullable = false, unique = true)
    private String statusName;
}
