package com.avik.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DFlatMapper {

  public static void main(String[] args) {

    List<User> users =
        Arrays.asList(
            new User("Peter", 20, Arrays.asList("1", "2")),
            new User("Sam", 40, Arrays.asList("3", "4", "5")),
            new User("Ryan", 60, Arrays.asList("6")),
            new User("Peter", 70, Arrays.asList("7", "8")));

    // find user with phone number 5
    users
        .stream()
        .filter(user -> user.getPhoneNumbers().contains("5"))
        .collect(Collectors.toList())
        .forEach(System.out::println);

    // using FlatMap - takes stream and gives out stream
    // we create a stream of phone nos
    // and push it into flatMap which gives a stream after a filter
    // findAny gives out Optional
    // Optional wraps object into typesafe thing
    Optional<String> optional =
        users
            .stream()
            .map(user -> user.getPhoneNumbers().stream())
            .flatMap(phoneNumbers -> phoneNumbers.filter(phoneNumber -> phoneNumber.contains("5")))
            .findAny();
    optional.ifPresent(System.out::println);
  }

  static class User {

    private String name;
    private int age = 30;
    private List<String> phoneNumbers;

    public User(String name, int age, List<String> phoneNumbers) {
      super();
      this.name = name;
      this.age = age;
      this.phoneNumbers = phoneNumbers;
    }

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

    public List<String> getPhoneNumbers() {
      return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
      this.phoneNumbers = phoneNumbers;
    }
  }
}
