/**
 * Created with IntelliJ IDEA. User: chengwei Date: 30/07/14 Time: 10:06 To
 * change this template use File | Settings | File Templates.
 */
public class cell {

    private cellState cellState;
    private cellState cellNextState;
    private int age;

    public cell() {
        this.cellState = cellState.DEAD;
        this.age = 0;
    }

    public int getAge() {
        return this.age;
    }

    public boolean isAlive() {
        return this.cellState == cellState.ALIVE;
    }

    public boolean isSurvived() {
        return this.cellNextState == cellState.ALIVE;
    }

    public void seed() {
        this.cellState = cellState.ALIVE;
    }

    public void update() {
        this.cellState = this.cellNextState;
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
        this.cellNextState = cellState.DEAD;
        this.age = 0;
    }

    private void reproduceNext() {
        this.cellNextState = cellState.ALIVE;
        this.age++;
    }

    private void survive() {
        this.cellNextState = this.cellState;
        this.age++;
    }


}
