package model;

import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        User user1 = new User();
        user1.setFirstName("Roman");
        user1.setLastName("Shcherbich");

        Thread.sleep(3000);

        System.out.println(6 / 0);

        System.out.println(user1.toString());

        User user2 = User.builder()
                .firstName("Roman")
                .lastName("shcherbich")
                .username("Username")
                .build();
        System.out.println(user2.toString());
        User user3 = new User()
                .withUsername("New");
        user3.withUsername("NEW 2");
        System.out.println(user3.toString());
    }

}
