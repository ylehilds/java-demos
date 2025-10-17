package dev.lehi.datastructures;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ArraysAndList {
    public static void main(String[] args) {
        System.out.println("ArrayList<String> example");
        ArrayList<String> list = new ArrayList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        System.out.println(list);
        list.remove("a2");
        System.out.println(list);

        System.out.println("\nString[] example");
        // how to remove an element on a regular String[] it takes more work and it requires to rebuild the String[]
        // This example shows how to do that using stream. ArrayList makes this much easier...
        String[] list2 = {"t1", "t2", "t3"};
        String removeValue = "t2";

        String[] newList = Arrays.stream(list2)
                .filter(s -> !s.equals(removeValue))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(newList)); // [t1, t3]

        System.out.println("\nList<String> example");
        // ✅ Example using a List<String> with ArrayList
        List<String> temp = new ArrayList<>();
        temp.add("x1");
        temp.add("x2");
        temp.add("x3");
        System.out.println(temp); // [x1, x2, x3]

        temp.remove("x2"); // easily removes by value
        System.out.println(temp); // [x1, x3]

        // or remove by index:
        temp.remove(0);
        System.out.println(temp); // [x3]
    }
}
