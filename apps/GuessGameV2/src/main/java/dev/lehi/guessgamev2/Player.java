package dev.lehi.guessgamev2;

import java.util.Scanner;

public class Player {
  public int number;

  public void guess() {
      System.out.print("enter a number: ");
      Scanner scanner = new Scanner(System.in);
      number = scanner.nextInt();
  }
}
