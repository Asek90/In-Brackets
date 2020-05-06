package org.ewarsztat.approach.test.playgroundStuff;

public class Person {

    private String name;
    private String secondName;
    private Gender gender;



    private int age;
    public Person(){}
    public Person(String name, String secondName,Gender gender, int age) {
        this.name = name;
        this.secondName = secondName;
        this.gender=gender;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSecondName() {
        return secondName;
    }
    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
