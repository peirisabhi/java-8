package org.example.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 18/05/2023
 * Time: 15:06
 */
public class Ex1 {
    public static void main(String[] args) {
        String s = "asqwasdawaa";

        Map<String, Long> countMap = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));

        System.out.println(countMap);


    }
}
