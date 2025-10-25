package dev.lehi.battleship;

public class BattleShipApp {
  public static void main(String[] args) {
    int numOfGuesses = 0;
    GameHelper helper = new GameHelper();

    BattleShip ship = new BattleShip();
    int randomNum = (int) (Math.random() * 5);

    int[] locations = {randomNum, randomNum + 1, randomNum + 2};
    ship.setLocationCells(locations);
    boolean isAlive = true;

    while (isAlive) {
      int guess = helper.getUserInput("enter a number");
      String result = ship.checkYourself(guess);
      numOfGuesses++;
      if (result.equals("kill")) {
        isAlive = false;
        System.out.println("You took " + numOfGuesses + " guesses");
      }
    }
  }
}
