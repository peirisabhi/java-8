package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 17/05/2023
 * Time: 17:06
 */
public class Test {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(23, 4, 6, 8, 9, 2, 1, 10);

        list.stream()
                .filter(i -> i > 4)
                .sorted()
                .forEach(System.out::println);  //method reference


        List<User> users = Stream.of(
                new User("user1", "121212121", Arrays.asList("u1@gmail.com", "u11@gmail.com")),
                new User("user1", "121212121", Arrays.asList("u2@gmail.com", "u22@gmail.com"))
        ).collect(Collectors.toList());


        List<String> userPhones = users.stream()
                .map(User::getPhone)
                .collect(Collectors.toList());

        System.out.println(userPhones);

        List<List<String>> userEmailsMap = users.stream()
                .map(User::getEmail)
                .collect(Collectors.toList());

        System.out.println(userEmailsMap);


        List<String> userEmailsFlatMap = users.stream()
                .flatMap(user -> user.getEmail().stream())
                .collect(Collectors.toList());

        System.out.println(userEmailsFlatMap);

    }
}
