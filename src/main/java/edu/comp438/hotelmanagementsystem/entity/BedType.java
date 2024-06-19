package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "bed_type")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BedType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Bed type name is mandatory")
    @Column(name = "bed_type_name", nullable = false)
    private String bedTypeName;
}
