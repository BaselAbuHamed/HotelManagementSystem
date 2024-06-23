package edu.comp438.hotelmanagementsystem.assembler;

import edu.comp438.hotelmanagementsystem.dto.CustomerDTO;
import edu.comp438.hotelmanagementsystem.entity.Customer;
import edu.comp438.hotelmanagementsystem.controller.CustomerController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<CustomerDTO> > {

    @Override
    @NonNull
    public EntityModel<CustomerDTO> toModel(@NonNull Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber()
        );

        EntityModel<CustomerDTO> customerEntityModel = EntityModel.of(customerDTO);
        customerEntityModel.add(linkTo(methodOn(CustomerController.class).getCustomerById(customer.getId())).withSelfRel());
        return customerEntityModel;
    }
}
