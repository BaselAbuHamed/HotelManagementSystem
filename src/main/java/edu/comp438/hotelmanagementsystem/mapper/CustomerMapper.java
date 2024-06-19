package edu.comp438.hotelmanagementsystem.mapper;

import edu.comp438.hotelmanagementsystem.dto.CustomerDTO;
import edu.comp438.hotelmanagementsystem.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDto(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmailAddress(),
                customer.getPhoneNumber()
        );
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmailAddress(customerDTO.getEmailAddress());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }
}
