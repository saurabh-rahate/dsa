package scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalTest {
    private static User user = new User(new Address("Street"));

    private static Optional<User> getUser() {
        return Optional.ofNullable(user);
    }

    public static void main(String[] args) {
        Optional<User> u = getUser();

        String address = u.map(User::getAddress).map(Address::getStreet).orElse(anotherStreet());

        System.out.println(address);

        List<String> list = getList().orElse(new ArrayList<>());

        System.out.println();

        List<String> gamesList = new ArrayList<>();
        gamesList.add("Football");
        gamesList.add("Cricket");
        gamesList.add("Chess");
        gamesList.add("Hocky");

        gamesList.forEach(System.out::println);
        System.out.println();
        gamesList.parallelStream().forEach(System.out::println);
        System.out.println();
        gamesList.parallelStream().forEachOrdered(System.out::println);
    }

    private static Optional<List<String>> getList() {
        return Optional.of(List.of("Street1"));
    }

    private static String anotherStreet() {
        System.out.println("Another Street");
        return "Another Street";
    }
}

class User {
    private Address address;

    public User(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }
}
