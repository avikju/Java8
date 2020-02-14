package com.avik.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CMapperInt {

  public static void main(String[] args) {

    List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
    List<User> users =
        names.stream().filter(CMapperInt::isNotSam).map(User::new).collect(Collectors.toList());
    users.forEach(System.out::println);

    // mapToInt creates IntStream so that we can perform sum,count etc operations
    // sum is a terminal operation
    // User::getAge - we are using method reference
    int sum = users.stream().mapToInt(User::getAge).sum();
    System.out.println(sum);
  }

  private static boolean isNotSam(String name) {
    return !name.equals("Sam");
  }

  static class User {

    private String name;
    private int age = 30;

    public User(String name) {
      super();
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return "User [name=" + name + ", age=" + age + "]";
    }
  }
}
