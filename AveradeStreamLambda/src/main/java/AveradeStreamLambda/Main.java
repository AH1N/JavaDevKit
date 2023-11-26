package AveradeStreamLambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        System.out.println(Stream.of(1, 2, 3, 4, 5, 6).
                filter(number -> number % 2 == 0).
                collect(Collectors.averagingDouble(Integer::doubleValue)));
    }
}