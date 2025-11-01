package dev.lehi.battleshipv2;

import java.util.*;

public class GameHelper {
  private static final String ALPHABET = "abcdefg";
  private static final int GRID_LENGTH = 7;
  private static final int GRID_SIZE = 49;
  private static final int MAX_ATTEMPTS = 200;

  static final int HORIZONTAL_INCREMENT = 1;          // A better way to represent these two
  static final int VERTICAL_INCREMENT = GRID_LENGTH;  // things is an enum (see Appendix B)

  private final int[] grid = new int[GRID_SIZE];
  private final Random random = new Random();

  private int battleshipCount = 0;

  public String getUserInput(String prompt) {
    System.out.print(prompt + ": ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().toLowerCase();
  }

  public ArrayList<String> placeBattleship(int battlehipSize) {
    // holds index to grid (0 - 48)
    int[] battleshipCoords = new int[battlehipSize];    // current candidate co-ordinates
    int attempts = 0;                                   // current attempts counter
    boolean success = false;                            // flag = found a good location?

    battleshipCount++;                                  // nth Battlesip to place
    int increment = getIncrement();                     // alternate vert & horiz alignment

    while (!success & attempts++ < MAX_ATTEMPTS) {      // main search loop
      int location = random.nextInt(GRID_SIZE);         // get random starting point

      for (int i = 0; i < battleshipCoords.length; i++) {  // create array of proposed coords
        battleshipCoords[i] = location;                    // put current location in array
        location += increment;                          // calculate the next location
      }
      System.out.println("Trying: " + Arrays.toString(battleshipCoords));

      if (BattlesipFits(battleshipCoords, increment)) {      // Battlesip fits on the grid?
        success = coordsAvailable(battleshipCoords);       // ...and locations aren't taken?
      }
    }

    savePositionToGrid(battleshipCoords);                  // coords passed checks, save
    ArrayList<String> alphaCells = convertCoordsToAlphaFormat(battleshipCoords);
    System.out.println("Placed at: "+ alphaCells);
    return alphaCells;
  }

  boolean BattlesipFits(int[] battleshipCoords, int increment) {
    int finalLocation = battleshipCoords[battleshipCoords.length - 1];
    if (increment == HORIZONTAL_INCREMENT) {
      // check end is on same row as start
      return calcRowFromIndex(battleshipCoords[0]) == calcRowFromIndex(finalLocation);
    } else {
      return finalLocation < GRID_SIZE;                 // check end isn't off the bottom
    }
  }

  boolean coordsAvailable(int[] battleshipCoords) {
    for (int coord : battleshipCoords) {                   // check all potential positions
      if (grid[coord] != 0) {                           // this position already taken
        System.out.println("position: " + coord + " already taken.");
        return false;                                   // NO success
      }
    }
    return true;                                        // there were no clashes, yay!
  }

  void savePositionToGrid(int[] battleshipCoords) {
    for (int index : battleshipCoords) {
      grid[index] = 1;                                  // mark grid position as 'used'
    }
  } //end savePositionToGrid

  private ArrayList<String> convertCoordsToAlphaFormat(int[] battleshipCoords) {
    ArrayList<String> alphaCells = new ArrayList<String>();
    for (int index : battleshipCoords) {                   // for each grid coordinate
      String alphaCoords = getAlphaCoordsFromIndex(index); // turn it into an "a0" style
      alphaCells.add(alphaCoords);                      // add to a list
    }
    return alphaCells;                                  // return the "a0"-style coords
  }

  String getAlphaCoordsFromIndex(int index) {
    int row = calcRowFromIndex(index);                  // get row value
    int column = index % GRID_LENGTH;                   // get numeric column value

    String letter = ALPHABET.substring(column, column + 1); // convert to letter
    return letter + row;
  }

  private int calcRowFromIndex(int index) {
    return index / GRID_LENGTH;
  }

  private int getIncrement() {
    if (battleshipCount % 2 == 0) {                      // if EVEN Battlesip
      return HORIZONTAL_INCREMENT;                      // place horizontally
    } else {                                            // else ODD
      return VERTICAL_INCREMENT;                        // place vertically
    }
  }
}
