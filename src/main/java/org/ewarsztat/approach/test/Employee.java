package org.ewarsztat.approach.test;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMP_ID")
    private int empId;

    @Column(name ="name")
    private String name;
}
