package dev.lehi.guessgame;

import java.util.Random;

public class Player {
  public int number;

  public void guess() {
    Random randomNumber = new Random();
    number = randomNumber.nextInt(10);
  }
}
