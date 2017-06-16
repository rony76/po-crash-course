package com.tagetik.agile.younameit.whatever.datastores;

import java.util.Optional;

import static java.util.Arrays.stream;

public class PeopleRepository {
    private static final Person[] THE_PEOPLE = {
            new Person("Fabio", Gender.MALE),
            new Person("Marco", Gender.MALE),
            new Person("Luca", Gender.MALE),
            new Person("Anthony", Gender.MALE),
            new Person("Sonia", Gender.FEMALE),
            new Person("Annarita", Gender.FEMALE),
            new Person("Ilaria", Gender.FEMALE)
    };

    public enum Gender {
        MALE, FEMALE
    }

    public static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }
    }

    public Optional<Person> findPersonByName(String name) {
        return stream(THE_PEOPLE).filter(p -> p.getName().equals(name)).findAny();
    }
}
