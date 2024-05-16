package com.mikhi.hibernateAston.service.impl;

import com.mikhi.hibernateAston.controller.dto.CustomerDto;
import com.mikhi.hibernateAston.entity.Customer;
import com.mikhi.hibernateAston.exceptions.ResourceNotFoundException;
import com.mikhi.hibernateAston.mapper.CustomerMapper;
import com.mikhi.hibernateAston.repository.CustomerRepository;
import com.mikhi.hibernateAston.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer not found with id: " + id)
                );
        return CustomerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map((customer) -> CustomerMapper.toDto(customer))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer updatedCustomer = customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer not found with id: " + id)
        );
        updatedCustomer.setFirstName(customerDto.getFirstName());
        updatedCustomer.setLastName(customerDto.getLastName());
        updatedCustomer.setEmail(customerDto.getEmail());

        Customer updatedCustomerObj = customerRepository.save(updatedCustomer);

        return CustomerMapper.toDto(updatedCustomerObj);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Customer not found with id: " + id)
        );
        customerRepository.delete(customer);
    }
}
