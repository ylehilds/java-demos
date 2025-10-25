package dev.lehi.battleship;

public class BattleShipTestDrive {
  public static void main(String[] args) {
    BattleShip dot = new BattleShip();

    int[] locations = {2, 3, 4};
    dot.setLocationCells(locations);

    int userGuess = 2;
    String result = dot.checkYourself(userGuess);
    String testResult = "failed";
    if (result.equals("hit")) {
      testResult = "passed";
    }
    System.out.println(testResult);
  }
}
