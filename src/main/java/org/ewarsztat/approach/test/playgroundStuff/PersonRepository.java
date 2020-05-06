package org.ewarsztat.approach.test.playgroundStuff;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonRepository {

    private static Map<String, Person> personMap = new HashMap<>(2);

    static {
        personMap.put("Piotr", new Person("Piotr", "Gawel", Gender.Male, 30));
        personMap.put("Kasienka", new Person("Kasia", "Placek", Gender.Female, 25));
        personMap.put("Mateusz", new Person("Mateusz", "Stolik", Gender.Male, 50));
        personMap.put("adam", new Person("adam", "Rupiec", Gender.Male, 50));
    }

    private PersonRepository() {

    }

    public static Optional<Person> findByName(String name) {
        return Optional.ofNullable(personMap.get(name));
    }

    public static Optional<Person> findAllMales(Gender gender) {
        return personMap.values().stream()
                .filter(person -> person.getGender() == gender).findAny();
    }
}
