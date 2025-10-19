package dev.lehi.guessgame;

public class GuessGame {
  Player p1;
  Player p2;
  Player p3;
  Player p4;
  Player p5;

  public void startGame() {
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();
    p4 = new Player();
    p5 = new Player();

    int guessp1 = 0;
    int guessp2 = 0;
    int guessp3 = 0;
    int guessp4 = 0;
    int guessp5 = 0;

    boolean p1isRight = false;
    boolean p2isRight = false;
    boolean p3isRight = false;
    boolean p4isRight = false;
    boolean p5isRight = false;

    int targetNumber = (int) (Math.random() * 10);
    System.out.println("Thinking of a number between 0 and 9...");

    while (true) {
      System.out.println("Number to guess is " + targetNumber);

      p1.guess();
      p2.guess();
      p3.guess();
      p4.guess();
      p5.guess();

      guessp1 = p1.number;
      System.out.println("Player one guessed " + guessp1);

      guessp2 = p2.number;
      System.out.println("Player two guessed " + guessp2);

      guessp3 = p3.number;
      System.out.println("Player three guessed " + guessp3);

      guessp4 = p4.number;
      System.out.println("Player four guessed " + guessp4);

      guessp5 = p5.number;
      System.out.println("Player five guessed " + guessp5);

      if (guessp1 == targetNumber) {
        p1isRight = true;
      }
      if (guessp2 == targetNumber) {
        p2isRight = true;
      }
      if (guessp3 == targetNumber) {
        p3isRight = true;
      }
      if (guessp4 == targetNumber) {
          p4isRight = true;
      }
      if (guessp5 == targetNumber) {
          p5isRight = true;
      }

      if (p1isRight || p2isRight || p3isRight || p4isRight || p5isRight) {

        System.out.println("We have a winner!");
        System.out.println("Player one got it right? " + p1isRight);
        System.out.println("Player two got it right? " + p2isRight);
        System.out.println("Player three got it right? " + p3isRight);
        System.out.println("Player Four got it right? " + p4isRight);
        System.out.println("Player Five got it right? " + p5isRight);
        System.out.println("Game is over.");
        break; // game over, break out of the loop
      } else {
        // no right guesses
        System.out.println("Players try again!");
      }
    }
  }
}