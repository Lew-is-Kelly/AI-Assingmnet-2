/**
 * Class with a data type for solving four queens problem
 *
 * @author Lewis Kelly
 */
public class Queens {
  private int row;
  private final int column;

  /**
   * Queens grid.
   *
   * @param row Number of rows
   * @param column Number of columns
   */
  public Queens(int row, int column) {
    this.row = row;
    this.column = column;
  }

  /**
   * Increments Queens row.
   */
  public void move () {
    row++;
  }

  /**
   * Check for conflicts of queen position.
   *
   * @param q New queen
   * @return False if queen cannot be placed, true if it can.
   */
  public boolean conflicts(Queens q){
    //  Check rows and columns
    if(row == q.getRow() || column == q.getColumn())
      return true;
      //  Check diagonals
    else
      return Math.abs(column - q.getColumn()) == Math.abs(row - q.getRow());
  }

  /**
   * Getter for the number of rows.
   *
   * @return number of rows
   */
  public int getRow() {
    return row;
  }

  /**
   * Getter for the number of columns.
   *
   * @return number of columns
   */
  public int getColumn() {
    return column;
  }
}
