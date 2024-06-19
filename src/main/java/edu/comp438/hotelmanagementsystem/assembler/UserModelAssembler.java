package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.UserDTO;
import edu.comp438.hotelmanagementsystem.entity.User;
import edu.comp438.hotelmanagementsystem.controller.UserController;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, UserDTO> {

    @Override
    @NonNull
    public UserDTO toModel(@NonNull User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getUsername(),
                null, // Exclude password for security reasons
                user.getEmail(),
                user.getRoles().stream().findFirst().get().getName() // Assuming a user has one role
        );

        userDTO.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
        return userDTO;
    }
}
