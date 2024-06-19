package edu.comp438.hotelmanagementsystem.service;

import edu.comp438.hotelmanagementsystem.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    CustomerDTO getCustomerById(Long id);
    void deleteCustomer(Long id);
    List<CustomerDTO> getAllCustomers();
}
