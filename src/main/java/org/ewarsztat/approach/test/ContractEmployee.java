package org.ewarsztat.approach.test;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT_EMPLOYEE")
@DiscriminatorValue("CONTRACT_EMP")
public class ContractEmployee extends Employee {

    @Column(name = "TYPE")
    private String type;
}