package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.UserDTO;
import edu.comp438.hotelmanagementsystem.entity.User;
import edu.comp438.hotelmanagementsystem.controller.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<UserDTO>> {

    @Override
    @NonNull
    public EntityModel<UserDTO> toModel(@NonNull User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getUsername(),
                null, // Exclude password for security reasons
                user.getEmail(),
                user.getRoles().stream().findFirst().get().getName() // Assuming a user has one role

        );
        EntityModel<UserDTO> entityModel  = EntityModel.of(userDTO);
        entityModel.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
        return entityModel;
    }
}
