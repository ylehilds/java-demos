package dev.lehi.datastructures;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // HashSet example #1"
        Set<String> list = new HashSet<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        System.out.println(list);
        list.add("a2");
        System.out.println("HashSet #1: " + list + "\n");

        // HashSet example #2
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // duplicate ignored

        System.out.println("HashSet #2 (unordered, no duplicates): " + fruits + "\n");

        // LinkedHashSet example
        Set<String> colors = new LinkedHashSet<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Blue"); // duplicate ignored

        System.out.println("LinkedHashSet (keeps order): " + colors + "\n");

        // TreeSet example
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(30);
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // duplicate ignored

        System.out.println("TreeSet (sorted): " + numbers);
    }
}
