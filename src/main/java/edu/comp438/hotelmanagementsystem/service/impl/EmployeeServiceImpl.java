package edu.comp438.hotelmanagementsystem.service.impl;

import edu.comp438.hotelmanagementsystem.dto.EmployeeDTO;
import edu.comp438.hotelmanagementsystem.entity.Employee;
import edu.comp438.hotelmanagementsystem.entity.Role;
import edu.comp438.hotelmanagementsystem.mapper.EmployeeMapper;
import edu.comp438.hotelmanagementsystem.repository.EmployeeRepository;
import edu.comp438.hotelmanagementsystem.repository.RoleRepository;
import edu.comp438.hotelmanagementsystem.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleRepository roleRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        Role role = roleRepository.findById(employeeDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + employeeDTO.getRoleId()));
        employee.setRole(role);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Role role = roleRepository.findById(employeeDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + employeeDTO.getRoleId()));

        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmailAddress(employeeDTO.getEmailAddress());
        existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        existingEmployee.setRole(role);

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDto(updatedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toDto(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }
}
