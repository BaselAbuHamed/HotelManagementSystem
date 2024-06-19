package edu.comp438.hotelmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "housekeeping")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Housekeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull(message = "Task date is mandatory")
    @Column(name = "task_date", nullable = false)
    private LocalDate taskDate;

    @NotBlank(message = "Task description is mandatory")
    @Column(name = "task_description", nullable = false)
    private String taskDescription;

    @NotBlank(message = "Status is mandatory")
    @Column(name = "status", nullable = false)
    private String status;
}
