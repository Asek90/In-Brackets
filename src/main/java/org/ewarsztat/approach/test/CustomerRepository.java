package org.ewarsztat.approach.test;

import org.ewarsztat.approach.test.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CustomerRepository extends JpaRepository<Customer,Long> {

    }
