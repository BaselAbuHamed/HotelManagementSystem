package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.RoleDTO;
import edu.comp438.hotelmanagementsystem.entity.Role;
import edu.comp438.hotelmanagementsystem.controller.RoleController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class RoleModelAssembler implements RepresentationModelAssembler<Role, EntityModel<RoleDTO>> {

    @Override
    @NonNull
    public EntityModel<RoleDTO> toModel(@NonNull Role role) {
        RoleDTO roleDTO = new RoleDTO(
                role.getId(),
                role.getName()
        );

        EntityModel<RoleDTO> roleEntityModel = EntityModel.of(roleDTO);
        roleEntityModel.add(linkTo(methodOn(RoleController.class).getRoleById(role.getId())).withSelfRel());
        return roleEntityModel;
    }
}
