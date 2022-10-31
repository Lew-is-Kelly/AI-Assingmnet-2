/**
 * Class to solve the 4 queens problem.
 *
 * @author Lewis Kelly
 */
public class Main {

  /**
   * Main function, solves 4 queens problem.
   */
  public static void main(String[] args) {
    System.out.println("4 Queens Problem");

    boolean[][] grid = makeGrid(4);
    printGrid(grid);
  }

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
}