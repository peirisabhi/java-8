package org.example.stream;

import java.util.stream.IntStream;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 20/05/2023
 * Time: 14:26
 */
public class ParallelStream {
    public static void main(String[] args) {

        IntStream.range(1, 10).forEach(value -> System.out.println(Thread.currentThread().getName() + " " + value));

        System.out.println("-----------------------------------------");

        IntStream.range(1, 10).parallel().forEach(value -> System.out.println(Thread.currentThread().getName() + " " + value));

    }
}
