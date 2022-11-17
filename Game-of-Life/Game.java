import java.io.IOException;

public class Game {

    private Grid g;

    public Game(String f, int gens) throws IOException {
        this.g = new Grid(f);
        for (int i = 0; i < gens; i++) {
            g.Generations();
        }
    }

    public void Display() {
        g.PrintGrid();
    }
}
