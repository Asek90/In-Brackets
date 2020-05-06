package org.ewarsztat.approach.test.playgroundStuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;



interface MyInt{
    void uruchomSilnik();

};
class MyClasss implements MyInt{
    @Override
    public void uruchomSilnik() {
        System.out.println("BRUUM");
    }
};

public class PersonController {
    public static void main(String[] args) {

        MyInt my = new MyClasss();
        MyInt my1 = () -> { System.out.println("ZIUUUU"); };
        MyInt my2 = new MyInt() {
            @Override
            public void uruchomSilnik() {
                System.out.println("ZIUUUU2");
            }
        };
        my.uruchomSilnik();

        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        List<Integer> collect = list.stream().filter(i -> i == 1 || i ==2)
                .collect(Collectors.toList());

        Function<Integer, Person> integerPersonFunction = i -> new Person("", "", null, 9);
        Predicate<Integer> predicate = i -> i ==5;

        collect.stream().map(integerPersonFunction);
        collect.stream().filter(i -> {

            new Exception("");
            return i ==5;


        });

        Optional<Integer> integer = Optional.ofNullable(5);
        Optional<Integer> integer1 = integer.filter(i -> i == 1);
        integer1.map(integerPersonFunction);
        integer1.filter(predicate);
        Integer wyj = integer.orElseThrow(() -> new IllegalArgumentException("wyj"));
        Integer wyj1 = integer1.orElseThrow(() -> new IllegalArgumentException("wyj"));


        Optional<Person> mateusz = PersonRepository.findByName("Kasienka");
        Optional<Person> males = PersonRepository.findAllMales(Gender.Male);

        Optional<Person> person1 = males.filter(a -> a.getAge() == 1);
        Optional<Person> person2 = males.filter(a -> a.getSecondName() == "");

        Optional<List<Person>> optl;
        List<String> elo = new ArrayList<>();
        for (String s : elo)
        mateusz.map(Person::getName);

        for (int i=0; i<100;i++){

        }
        List<Integer> intList = new ArrayList<>(100);
        for (Integer s : intList)

         mateusz
//                 .filter(person -> person.getAge()>30)
//                 .filter(person -> person.getGender().equals(Gender.Male))
                 .map(Person::getName)
                 .map(String::toUpperCase)
                 .ifPresent(
                         System.out::println
                 );
//                 .orElseThrow(()->new RuntimeException("nie ma takiego typie na chuj szukasz"));

        males
                .filter(person -> Gender.Male.equals(person.getGender()))
                .ifPresent(    System.out::println);

    }
}

