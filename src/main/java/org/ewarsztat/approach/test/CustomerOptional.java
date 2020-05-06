package org.ewarsztat.approach.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerOptional {

    private List<Customer> customers;

    public CustomerOptional() {
        init();
        Optional<Customer> gawel = customers.stream().
                filter(element -> element.getLastName().
                        equals("gawelsd")).
                findFirst();

        Customer customerGawel = gawel.orElseThrow(() -> new RuntimeException("customer gawel doesnt exists"));
        System.out.println(customerGawel);
//     if (gawel.isPresent()){
//         System.out.println(gawel.get());
//     } else{
//         System.out.println("the name gawel doesnt exists");
//     }
    }

    private void init() {
        customers = new ArrayList<>();
        customers.add(new Customer("pawel", "gawel"));
        customers.add(new Customer("lukasz", "szukasz"));
        customers.add(new Customer("kiepasa", "amigo"));
        customers.add(new Customer("por", "farvore"));
    }

    public static void main(String[] args) {
        new CustomerOptional();
    }
}
