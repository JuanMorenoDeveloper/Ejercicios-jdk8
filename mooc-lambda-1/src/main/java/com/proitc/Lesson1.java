package com.proitc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Speakjava (Simon Ritter)
 */
public class Lesson1 {

  /**
   * Main entry point for application
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) {
    final Lesson1 lesson = new Lesson1();
    lesson.runExercises();
  }

  /**
   * All exercises should be completed using Lambda expressions and the new
   * methods added to JDK 8 where appropriate. There is no need to use an
   * explicit loop in any of the code. Use method references rather than full
   * lambda expressions wherever possible.
   */

  /**
   * Run the exercises to ensure we got the right answers
   */
  public void runExercises() {
    System.out.println("JDK 8 Lambdas and Streams MOOC Lesson 1");
    System.out.println("Running exercise 1 solution...");
    exercise1();
    System.out.println("Running exercise 2 solution...");
    exercise2();
    System.out.println("Running exercise 3 solution...");
    exercise3();
    System.out.println("Running exercise 4 solution...");
    exercise4();
    System.out.println("Running exercise 5 solution...");
    exercise5();
  }

  /**
   * Exercise 1
   * <p>
   * Create a string that consists of the first letter of each word in the list
   * of Strings provided.
   */
  private void exercise1() {
    final List<String> list = Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot");

    /* YOUR CODE HERE */
    final StringBuilder sb = new StringBuilder();
    //list.stream().map(s -> s.charAt(0)).forEach(sb::append);
    list.forEach(s -> sb.append(s.charAt(0)));
    System.out.println(sb.toString());
  }

  /**
   * Exercise 2
   * <p>
   * Remove the words that have odd lengths from the list.
   */
  private void exercise2() {
    final List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    /* YOUR CODE HERE */
    //list = list.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.toList());
    list.removeIf(s -> (s.length() & 1) == 0);
    System.out.println(list);
  }

  /**
   * Exercise 3
   * <p>
   * Replace every word in the list with its upper case equivalent.
   */
  private void exercise3() {
    final List<String> list = new ArrayList<>(Arrays.asList(
        "alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

    /* YOUR CODE HERE */
    //list=list.stream().map(s->s.toUpperCase()).collect(toList());
    list.replaceAll(s -> s.toUpperCase());
    System.out.println(list);
  }

  /**
   * Exercise 4
   * <p>
   * Convert every key-value pair of the map into a string and append them all
   * into a single string, in iteration order.
   */
  private void exercise4() {
    final Map<String, Integer> map = new TreeMap<>();
    map.put("c", 3);
    map.put("b", 2);
    map.put("a", 1);

    /* YOUR CODE HERE */
    final StringBuffer sb = new StringBuffer();
    //String s=map.entrySet().stream().map(m->m.getKey()+m.getValue()).collect(Collectors.joining());
    //map.forEach((k, v) -> sb.append(k).append(v));
    map.forEach((k, v) -> sb.append(String.format("%s %s", k, v)));
    System.out.println(sb.toString());
  }

  /**
   * Exercise 5
   * <p>
   * Create a new thread that prints the numbers from the list.
   */
  private void exercise5() {
    final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    /*
        Runnable task=()->{
        list.stream().forEach(out::println);
    };
    Thread thread= new Thread(task);
    thread.start();
    */
    /* YOUR CODE HERE */
    /*final Thread thread = new Thread(() -> {
      list.forEach(System.out::print);
    });
    thread.start();*/
    new Thread(() -> list.forEach(System.out::print)).start();
  }
}