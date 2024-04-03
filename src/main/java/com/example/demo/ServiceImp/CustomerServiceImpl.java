package com.example.demo.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.CustomerDto;
import com.example.demo.Repository.CustomerRepo;
import com.example.demo.Service.CustomerService;
import com.example.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepository;

    public CustomerServiceImpl(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer savedCustomer = customerRepository.save(mapDtoToEntity(customerDto));
        return mapEntityToDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            return mapEntityToDto(customer);
        } else {
            return null; 
        }
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                        .map(this::mapEntityToDto)
                        .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null) {
            // Update existing customer entity with new data from customerDto
            existingCustomer.setFirstname(customerDto.getFirstname());
            existingCustomer.setLastname(customerDto.getLastname());
            existingCustomer.setMobile(customerDto.getMobile());
            existingCustomer.setEmail(customerDto.getEmail());
            existingCustomer.setPlanid(customerDto.getPlanid());
            existingCustomer.setAddressid(customerDto.getAddressid());
           
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            
            return mapEntityToDto(updatedCustomer);
        } else {
            return null; 
        }
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        } else {
            return false; // or throw an exception indicating customer not found
        }
    }

    private Customer mapDtoToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setMobile(customerDto.getMobile());
        customer.setEmail(customerDto.getEmail());
        customer.setPlanid(customerDto.getPlanid());
        customer.setAddressid(customerDto.getAddressid());
        return customer;
    }

    // Utility method to convert Customer entity to CustomerDto
    private CustomerDto mapEntityToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstname(customer.getFirstname());
        customerDto.setLastname(customer.getLastname());
        customerDto.setMobile(customer.getMobile());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPlanid(customer.getPlanid());
        customerDto.setAddressid(customer.getAddressid());
        return customerDto;
    }

}
