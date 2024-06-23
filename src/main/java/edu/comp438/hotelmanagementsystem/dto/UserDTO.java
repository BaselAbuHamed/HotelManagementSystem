package edu.comp438.hotelmanagementsystem.dto;

import lombok.*;

import jakarta.validation.constraints.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Role is mandatory")
    private String role;
}
