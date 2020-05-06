package org.ewarsztat.approach.test;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERMANENT_EMPLOYEE")
@DiscriminatorValue("PERMANENT_EMP")
public class PermanentEmployee extends Employee {

    @Column(name = "TYPE")
    private String type;
}