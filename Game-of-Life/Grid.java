import java.io.IOException;

public class Grid {

  private static int columnCount = 20;
  private static int rowCount = 20;
  private static String[][] grid = new String[rowCount][columnCount];

  public Grid(String file) throws IOException {
    grid = FileRead.read(file);
    PrintGrid();
  }

  public void PrintGrid() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < columnCount; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public int NeighborCounter(int row, int col) {
    int n = 0;
    n += Alive(row - 1, col - 1);
    n += Alive(row - 1, col);
    n += Alive(row - 1, col + 1);
    n += Alive(row, col + 1);
    n += Alive(row + 1, col + 1);
    n += Alive(row + 1, col);
    n += Alive(row + 1, col - 1);
    n += Alive(row, col - 1);
    return n;
  }

  private int Alive(int row, int col) {
    if (row < 0)
      return 0;
    if (col < 0)
      return 0;
    if (row >= rowCount)
      return 0;
    if (col >= columnCount)
      return 0;
    return (grid[row][col].equals("X")) ? 1 : 0;
  }

  public void Generations() {
    String[][] newGrid = new String[rowCount][columnCount];

    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < columnCount; j++) {

        if ((grid[i][j].equals(".")) & (NeighborCounter(i, j) == 3)) {
          newGrid[i][j] = "X";
        } else if (grid[i][j].equals("X")) {
          if ((NeighborCounter(i, j) == 2) | (NeighborCounter(i, j) == 3)) {
            newGrid[i][j] = "X";
          } else {
            newGrid[i][j] = ".";
          }
        } else {
          newGrid[i][j] = ".";
        }
      }
    }
    grid = newGrid;
    PrintGrid();
  }
}