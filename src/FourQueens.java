import java.util.Random;

/**
 * Class to solve the four queens problem.
 *
 * @author Lewis Kelly
 */
public class FourQueens {
  private static int size;
  private static int heur = 0;

  /**
   * Crate a random grid of queens.
   *
   * @return Random grid
   */
  public static Queens[] makeGrid() {
    Queens[] initGrid = new Queens[size];
    Random rndm = new Random();
    for (int i = 0; i < size; i++) {
      initGrid[i] = new Queens(rndm.nextInt(size), i);
    }
    return initGrid;
  }

  /**
   * Print the state of queens for debugging
   *
   * @param gridState state of queens
   */
  private static void printState(Queens[] gridState) {
    // Creating temporary grid from the current grid
    int[][] tmpGrid = new int[size][size];
    for (int i = 0; i < size; i++) {
      // Get the positions of Queen from the current grid and set those positions as 1 in temp grid
      tmpGrid[gridState[i].getRow()][gridState[i].getColumn()] = 1;
    }
    System.out.println();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(tmpGrid[i][j] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Get the heuristic of a game state.
   *
   * @param state state of queens
   * @return Heuristic of state
   */
  public static int findHeur(Queens[] state) {
    int heur = 0;
    for (int i = 0; i < state.length; i++) {
      for (int j = i + 1; j < state.length; j++) {
        if (state[i].conflicts(state[j])) {
          heur++;
        }
      }
    }
    return heur;
  }

  /**
   * Generates a new grid with a lower heuristic.
   *
   * @param currGrid The current best grid generated
   * @return New better grid with lower heuristic
   */
  public static Queens[] newGrid(Queens[] currGrid) {
    Queens[] nextGrid = new Queens[size];
    Queens[] tmpGrid = new Queens[size];
    int currHeur = findHeur(currGrid);
    int bestHeur = currHeur;
    int tmpHeur;

    for (int i = 0; i < size; i++) {
      //  Copy present grid as best grid and temp grid
      nextGrid[i] = new Queens(currGrid[i].getRow(), currGrid[i].getColumn());
      tmpGrid[i] = nextGrid[i];
    }
    // Iterate each column
    for (int i = 0; i < size; i++) {
      if (i > 0) {
        tmpGrid[i - 1] = new Queens(currGrid[i - 1].getRow(), currGrid[i - 1].getColumn());
      }
      tmpGrid[i] = new Queens(0, tmpGrid[i].getColumn());
      // Iterate each row
      for (int j = 0; j < size; j++) {
        // Get the heuristic
        tmpHeur = findHeur(tmpGrid);
        // Check if temp grid is better than best grid
        if (tmpHeur < bestHeur) {
          bestHeur = tmpHeur;
          // Copy the temp grid as best grid
          for (int k = 0; k < size; k++) {
            nextGrid[k] = new Queens(tmpGrid[k].getRow(), tmpGrid[k].getColumn());
          }
        }
        //Move the queen
        if (tmpGrid[i].getRow() != size - 1) {
          tmpGrid[i].move();
        }
      }
    }
    // Check to see if the present grid and the best grid found have the same heuristic
    // Randomly generate new grid and assign it to best grid
    if (bestHeur == currHeur) {
      nextGrid = makeGrid();
      heur = findHeur(nextGrid);
    } else {
      heur = bestHeur;
    }
    return nextGrid;
  }

  /**
   * Main
   */
  public static void main(String[] args) {
    int currHeur;
    size = 4;
    // Initial grid of queens
    Queens[] currGrid = makeGrid();
    currHeur = findHeur(currGrid);
    // Loop until heuristic is 0 and therefore have a solution
    while (currHeur != 0) {
      // Make a new grid with a better heuristic
      currGrid = newGrid(currGrid);
      currHeur = heur;
    }
    // Print Solution
    printState(currGrid);
  }
}

///**
// * Class with a data type for solving four queens problem
// *
// * @author Lewis Kelly
// */
//public class Queens {
//  private int row;
//  private final int column;
//
//  /**
//   * Queens grid.
//   *
//   * @param row Number of rows
//   * @param column Number of columns
//   */
//  public Queens(int row, int column) {
//    this.row = row;
//    this.column = column;
//  }
//
//  /**
//   * Increments Queens row.
//   */
//  public void move () {
//    row++;
//  }
//
//  /**
//   * Check for conflicts of queen position.
//   *
//   * @param q New queen
//   * @return False if queen cannot be placed, true if it can.
//   */
//  public boolean conflicts(Queens q){
//    //  Check rows and columns
//    if(row == q.getRow() || column == q.getColumn())
//      return true;
//      //  Check diagonals
//    else
//      return Math.abs(column - q.getColumn()) == Math.abs(row - q.getRow());
//  }
//
//  /**
//   * Getter for the number of rows.
//   *
//   * @return number of rows
//   */
//  public int getRow() {
//    return row;
//  }
//
//  /**
//   * Getter for the number of columns.
//   *
//   * @return number of columns
//   */
//  public int getColumn() {
//    return column;
//  }
//}