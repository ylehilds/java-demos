package dev.lehi.helloworldv2;

import java.util.Scanner;

public class HelloWorldV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Please enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hello " + name + "!");
        } finally {
            scanner.close();
        }
    }
}
