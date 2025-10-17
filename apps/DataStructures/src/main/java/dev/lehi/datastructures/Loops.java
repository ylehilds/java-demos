package dev.lehi.datastructures;

public class Loops {
    public static void main(String[] args) {
        for (int i=0; i< 10; i++) {
            System.out.println(i);
        }

        boolean test = true;
        int i = 0;
        while (test) {
            System.out.println("i = " + i++);
            if (i == 5) test = false;
        }

        int[] nums = {6,7,8,9,10};
        for (int num : nums) {
            System.out.println("num element from int array:" + num);
        }
    }
}
