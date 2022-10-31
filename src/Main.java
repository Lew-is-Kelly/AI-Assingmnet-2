/**
 * Class to solve the 4 queens problem.
 *
 * @author Lewis Kelly
 */
public class Main {

  /**
   * Creates a square 2D boolean array representing the chess board.
   *
   * @param gridSize Size of the grid to be made.
   * @return 2D boolean array.
   */
  public static boolean[][] makeGrid(int gridSize) {
    boolean[][] grid = new boolean[gridSize][gridSize];
    for (int i = 0; i <= 3; i++) {
      for (int j = 0; j <= 3; j++) {
        grid[i][j] = false;
      }
    }
    return grid;
  }

  /**
   * Prints the state of the 2D boolean array grid passed with true printing as "Q" and false as
   * "_".
   *
   * @param grid Boolean grid of chess board.
   */
  public static void printGrid(boolean[][] grid) {
    for (boolean[] rows : grid) {
      for (int i = 0; i < grid.length; i++) {
        if (rows[i]) {
          System.out.print("Q ");
        } else {
          System.out.print("_ ");
        }
      }
      System.out.print("\n");
    }
  }

  /**
   * Checks if a position is under attack from a queen.
   *
   * @param posX X coordinate of position to check.
   * @param posY Y coordinate of position to check.
   * @param grid Boolean grid of the board.
   * @return true if the position is not under attack.
   */
  public static boolean canPlace (int posX, int posY, boolean[][] grid) {
    // Check place provided if queen is present
    if (grid[posX][posY]) {
      return false;
    }

    for (int i = 1; i < grid.length; i++) {
      int upX = posX + i;
      int dnX = posX - i;
      int upY = posY + i;
      int dnY = posY - i;

      //Check horizontal
      if (upX <= grid.length - 1) {
        if (grid[upX][posY]) {
          return false;
        }
      }
      if (dnX >= 0) {
        if (grid[dnX][posY]) {
          return false;
        }
      }

      // Check vertical
      if (upY <= grid.length - 1) {
        if (grid[posX][upY]) {
          return false;
        }
      }
      if (dnY >= 0) {
        if (grid[posX][dnY]) {
          return false;
        }
      }

      // Check diagonals
      if (dnX >= 0 && dnY >= 0) {
        if (grid[dnX][dnY]) {
          return false;
        }
      }
      if (upX <= grid.length - 1 && dnY >= 0) {
        if (grid[upX][dnY]) {
          return false;
        }
      }
      if (dnX >= 0 && upY <= grid.length - 1) {
        if (grid[dnX][upY]) {
          return false;
        }
      }
      if (upX <= grid.length - 1 && upY <= grid.length - 1) {
        if (grid[upX][upY]) {
          return false;
        }
      }
    }

    return true;
  }

  public static void placeQueen (int posX, int posY, boolean[][] grid) {
    grid[posX][posY] = true;
  }

  /**
   * Main.
   */
  public static void main(String[] args) {
    System.out.println("4 Queens Problem");

    boolean[][] grid = makeGrid(4);
    placeQueen(0, 0, grid);

    System.out.printf("%b\n", canPlace(3, 0, grid));

    printGrid(grid);
  }
}