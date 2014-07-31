/**
 * Created with IntelliJ IDEA. User: chengwei Date: 30/07/14 Time: 10:06 To
 * change this template use File | Settings | File Templates.
 */
public class Cell {

    private CellState state;
    private CellState nextState;
    private int age;

    public Cell() {
        this.state = CellState.DEAD;
        this.age = 0;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAlive() {
        return this.state == CellState.ALIVE;
    }

    public boolean isSurvived() {
        return this.nextState == CellState.ALIVE;
    }

    public void seed() {
        this.state = CellState.ALIVE;
    }

    public void update() {
        this.state = this.nextState;
    }

    public void setNextState(int aliveNeighbors) {
        if (this.isAlive()) {
            if (aliveNeighbors < 2) {
                this.killNext();
            }
            else if (aliveNeighbors == 2 || aliveNeighbors == 3)
            {
                this.survive();
            }
            else if (aliveNeighbors > 3) {
                this.killNext();
            }
        } else {
            if (aliveNeighbors == 3)
            {
                this.reproduceNext();
            }
        }
    }

    private void killNext() {
        this.nextState = CellState.DEAD;
        this.age = 0;
    }

    private void reproduceNext() {
        this.nextState = CellState.ALIVE;
        this.age++;
    }

    private void survive() {
        this.nextState = this.state;
        this.age++;
    }

}
