package com.avik.filter;

public class Test {

  public static void main(String[] args) {

    String target = "1010";
    System.out.println(theFinalProblem(target));
  }

  public static int theFinalProblem(String target) {

    int n = target.length();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = 0;
    }
    int flips = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (target.charAt(i) == '1') {
        flips++;
        arr[i] = 1;
      }
    }
    return flips;
  }
}
