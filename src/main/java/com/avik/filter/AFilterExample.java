package com.avik.filter;

import java.util.Arrays;
import java.util.List;

public class AFilterExample {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		names.stream().filter(AFilterExample::isNotSam).forEach(System.out::println);

	}

	private static boolean isNotSam(String name) {
		return !name.equals("Sam");
	}

}
