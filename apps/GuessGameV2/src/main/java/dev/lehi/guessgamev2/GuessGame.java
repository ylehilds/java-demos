package dev.lehi.guessgamev2;

public class GuessGame {
  Player player;

  public void startGame() {
    player = new Player();

    int guess = 0;

    boolean playerRight = false;

    int targetNumber = (int) (Math.random() * 10);
    System.out.println("Thinking of a number between 0 and 9...");

    while (true) {
      System.out.println("Number to guess is " + targetNumber);

      player.guess();

      guess = player.number;
      System.out.println("You guessed " + guess);

      if (guess == targetNumber) {
          playerRight = true;
      }

      if (playerRight) {
        System.out.println("We have a winner!");
        System.out.println("Game is over.");
        break; // game over, break out of the loop
      } else {
        // no right guesses
        System.out.println("Try again!");
      }
    }
  }
}