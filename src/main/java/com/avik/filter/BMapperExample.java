package com.avik.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BMapperExample {

  public static void main(String[] args) {

    List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
    List<User> users =
        names.stream().filter(BMapperExample::isNotSam).map(User::new).collect(Collectors.toList());
    users.forEach(System.out::println);
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
