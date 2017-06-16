import java.util.Optional;

public class Greeter {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("I don't know who to greet!");
            System.exit(1);
        }

        String name = properlyAddressPersonToGreet(args[0]);
        System.out.println(String.format("Hello %s!", name));

    }

    private static String properlyAddressPersonToGreet(String name) {
        // obtain a reference to the people repository
        PeopleRepository peopleRepository = new PeopleRepository();

        // lookup the person by name (who might not exist!)
        Optional<PeopleRepository.Person> personOptional = peopleRepository.findPersonByName(name);

        return personOptional.map(p -> {
            // if you actually managed to find that person, address them with proper title
            if (p.getGender() == PeopleRepository.Gender.MALE) {
                return "Mr " + name;
            } else {
                return "Mrs " + name;
            }
        })
                // if you didn't find anyone with that name... whatever!
                .orElse(name + " whoever you might be");
    }
}
