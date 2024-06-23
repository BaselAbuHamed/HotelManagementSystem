package edu.comp438.hotelmanagementsystem.dto;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import jakarta.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotBlank(message = "Email address is mandatory")
    @Email(message = "Email should be valid")
    private String emailAddress;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;
}
