package dev.lehi.datastructures;

public class Conditions {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Please provide 3 arguments.");
            System.out.println("Usage: java dev.lehi.datastructures.Conditions arg1 arg2 arg3");
            return;
        }
        System.out.println("Argument 1: " + args[0]);
        System.out.println("Argument 2: " + args[1]);
        System.out.println("Argument 3: " + args[2]);

        // If num1 = 5 and num2 = 3,
        // you’d expect Sum is: 8,
        // but Java prints: Sum is: 53
        int num1 = 5;
        int num2 = 3;
        System.out.println("Sum is: " + num1 + num2);

        // Because of operator precedence and left-to-right evaluation:
        // 1. "Sum is: " + num1 → this creates a string: "Sum is: 5"
        // 2. Then "Sum is: 5" + num2 → that’s string + number, so it concatenates again → "Sum is: 53"
        // Once a string is involved, all later + operations become string concatenations — no math happens after that.

        // Order of operations will fix this issue using paranthesis (num1 + num2)
        System.out.println("With parenthesis the Sum is: " + (num1 + num2));

        // General rule of thumb
	    // • + between numbers → adds
	    // • + between a string and anything → concatenates (turns it all into text)
	    // • Evaluation goes left to right, unless you use parentheses

        // "==" checks if they are the same object, not if they contain the same text.
        // ".equals()" checks the actual characters inside the string.
        if (args[0].equals("test1")) System.out.println("test1 args was passed");
        else if (args[1].equals("test2")) System.out.println("test2 was passed in");
        else System.out.println("arg being passed in was not expected");
    }
}
