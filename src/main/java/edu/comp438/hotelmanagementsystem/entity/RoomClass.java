package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "room_class")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoomClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Class name is mandatory")
    @Column(name = "class_name", nullable = false)
    private String className;

    @NotNull(message = "Base price is mandatory")
    @DecimalMin(value = "0.0", inclusive = false, message = "Base price must be greater than zero")
    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;
}
