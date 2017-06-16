public class HelloSomeone {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("I don't know who to greet!");
            System.exit(1);
        }

        String name = properlyAddressPersonToGreet(args[0]);
        System.out.println(String.format("Hello %s!", name));
    }

    private static String properlyAddressPersonToGreet(String name) {
        switch (name) {
            case "Fabio":
            case "Marco":
            case "Luca":
            case "Anthony":
                return "Mr " + name;

            case "Sonia":
            case "Annarita":
            case "Ilaria":
                return "Mrs " + name;

            default:
                return name + ", whoever you are";
        }
    }
}
