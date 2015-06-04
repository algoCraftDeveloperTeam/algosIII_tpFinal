package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 04/06/15.
 */
public class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
