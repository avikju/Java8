package com.avik.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeekSkipExample {

  public static void main(String[] args) {

    // 1.This method exists mainly to support debugging, where you want to see the elements as they
    // flow past a certain point in a pipeline.
    // 2.Since Java 9, if the number of elements is known in advance and unchanged in the stream,
    // the
    // .peek () statement will not be executed due to performance optimization. It is possible to
    // force its operation by a command (formal) changing the number of elements eg. .filter (x ->
    // true).
    // 3.Using peek without any terminal operation does nothing.

    // Creating a list of Integers
    List<Integer> list = Arrays.asList(0, 2, 4, 6, 8, 10);

    // Using peek without any terminal
    // operation does nothing. Hence this
    // code will produce no output.
    list.stream().peek(System.out::println);

    // peek with filter so it will produce output - Two and Three
    List<String> strings =
        Stream.of("One", "Two", "Three")
            .filter(obj -> !obj.equals("One"))
            .peek(obj -> System.out.println(obj))
            .collect(Collectors.toList());

    // peek with count -  all the strings will be printed
    Stream.of("One", "Two", "Three").peek(obj -> System.out.println(obj)).count();

    // Skip - to skip no. of elements in Stream
    IntStream.of(1, 23, 5, 4, 7, 8, 9, 10).skip(2).filter(i -> i > 5).forEach(System.out::println);
  }
}
