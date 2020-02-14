package com.avik.filter;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuntionalInterfaceTest {

  public static void main(String[] args) {

    // Predicate
    Predicate<Integer> p = (Integer x) -> x % 2 == 0;

    System.out.println(p.test(90));

    BinaryOperator<Integer> b = (Integer m, Integer n) -> m + n;
    System.out.println(b.apply(5, 10));

    Function<String, Boolean> f =
        (String s) -> {
          return new StringBuffer(s).reverse().toString().equals(s);
        };
    System.out.println("Is palindrome?" + f.apply("abx"));
  }
}
