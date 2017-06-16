import java.util.Optional;

import static java.util.Arrays.stream;

class PeopleRepository {
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

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        String getName() {
            return name;
        }

        Gender getGender() {
            return gender;
        }
    }

    Optional<Person> findPersonByName(String name) {
        return stream(THE_PEOPLE).filter(p -> p.getName().equals(name)).findAny();
    }
}
