package org.ewarsztat.approach.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("HelloWorldController")
@RequiredArgsConstructor
public class HelloWorldController {


    private final CustomerService customerService;


    @RequestMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }

    //TODO
    //add post
    @RequestMapping("/customer")
    public void adddJohn() {
        customerService.save(new Customer("John", "Doe"));
        customerService.save(new Customer("pawel", "gawel"));
        customerService.save(new Customer("lukasz", "szukasz"));
        customerService.save(new Customer("kiepasa", "amigo"));
        customerService.save(new Customer("por", "farvore"));
    }

    @RequestMapping(value = "/customer/{id}")
    @ResponseBody
    public Customer getById(@PathVariable("id") Long id) {
        return customerService.getById(id).orElseThrow(() -> new RuntimeException("customer gawel doesnt exists"));
    }

    @RequestMapping(value = "/saveCustomer/{firstName}/{lastName}")
    @ResponseBody
    public void saveCustomer(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        customerService.save(new Customer(firstName, lastName));
    }

}
