package org.ewarsztat.approach.test;

import lombok.RequiredArgsConstructor;
import org.ewarsztat.approach.test.Customer;
import org.ewarsztat.approach.test.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    public List<String> getNames(){
        return customerRepository.findAll().stream().map(customer-> customer.getFirstName()).collect(Collectors.toList());
    }
    public Optional<Customer> getById(Long id){
        return customerRepository.findById(id);
    }
}
