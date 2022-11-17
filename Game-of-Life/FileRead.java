import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

  private static int columnCount = 20;
  private static int rowCount = 20;
  private static String[][] grid = new String[rowCount][columnCount];

  public static String[][] read(String f) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(f));

    for (int i = 0; i < rowCount; i++) {
      String line = br.readLine();

      for (int j = 0; j < columnCount; j++) {
        grid[i][j] = String.valueOf(line.charAt(j));
      }
    }
    br.close();
    return grid;
  }
}