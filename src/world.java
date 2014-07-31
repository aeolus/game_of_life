/**
 * Created with IntelliJ IDEA. User: chengwei Date: 30/07/14 Time: 09:32 To
 * change this template use File | Settings | File Templates.
 */
public class World {

    private final int dimension;
    private Cell[][] myWorld;

    public World(int dim) {
        this.dimension = dim;
        this.myWorld = new Cell[dim][dim];

        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                this.myWorld[i][j] = new Cell();
            }
        }
    }

    public void random() {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (Math.random() > 0.5) {
                    this.myWorld[i][j].seed();
                }
            }
        }
    }

    public void seed(int x, int y) {
        this.myWorld[x][y].seed();
    }

    public boolean isAlive(int x, int y) {
        return this.myWorld[x][y].isAlive();
    }

    public void tick() {
        int alives;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                alives = this.countAliveNeighbor(i, j);
                this.myWorld[i][j].setNextState(alives);
            }
        }

        // flush
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                this.myWorld[i][j].update();
            }
        }
    }

    public int countAliveNeighbor(int x, int y) {
        return countNeighborInState(x, y);
    }

    private int countNeighborInState(int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int n_x = x + i;
                int n_y = y + j;

                if (n_x < 0 || n_x >= this.dimension || n_y < 0 || n_y >= this.dimension) {
                    continue;
                }
                sum += (this.myWorld[n_x][n_y].isAlive()) ? 1 : 0;
            }
        }
        return sum;
    }

    public void print() {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                Cell c = this.myWorld[i][j];
                if (c.isAlive()) {
                    System.out.print(formatAge(c.getAge()) + " ");
                } else {
                    System.out.print("  . ");
                }
            }
            System.out.println("");
        }
    }

    private String formatAge(int a) {
        if (0 <= a && a < 10) {
            return "  " + a;
        }
        if (9 < a && a < 100) {
            return " " + a;
        }
        else {
            return Integer.toString(a);
        }
    }
}
