package dev.lehi.battleshipv2;

import java.util.ArrayList;

public class BattleshipTestDrive {

  private GameHelper helper = new GameHelper();
  private ArrayList<BattleShip> battleships = new ArrayList<BattleShip>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    // first make some battleships and give them locations
    BattleShip one = new BattleShip();
    one.setName("arizona");
    BattleShip two = new BattleShip();
    two.setName("bismarck");
    BattleShip three = new BattleShip();
    three.setName("dreadnought");
    battleships.add(one);
    battleships.add(two);
    battleships.add(three);

    System.out.println("The goal is to sink 3 battleships.");
    System.out.println("arizona, bismarck, dreadnought");
    System.out.println("Try to sink them all in the fewest number of guesses");

    for (BattleShip battleship : battleships) {
      ArrayList<String> newLocation = helper.placeBattleship(3);
        battleship.setLocationCells(newLocation);
    }
  }

  private void startPlaying() {
    while (!battleships.isEmpty()) {
      String userGuess = helper.getUserInput("Enter a guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }

  private void checkUserGuess(String userGuess) {
    numOfGuesses++;
    String result = "miss"; // assume a miss until told otherwise

    for (BattleShip battleshipToTest : battleships) {
      result = battleshipToTest.checkYourself(userGuess);

      if (result.equals("hit")) {
        break;
      }
      if (result.equals("kill")) {
        battleships.remove(battleshipToTest); // he's gone
        break;
      }
    }

    System.out.println(result);
  }

  private void finishGame() {
    System.out.println("All battleships are dead! Your stock is now worthless");
    if (numOfGuesses <= 18) {
      System.out.println("It only took you " + numOfGuesses + " guesses.");
      System.out.println("You got out before your options sank.");
    } else {
      System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
      System.out.println("Fish are dancing with your options");
    }
  }

  public static void main(String[] args) {
    BattleshipTestDrive game = new BattleshipTestDrive();
    game.setUpGame();
    game.startPlaying();
  }
}