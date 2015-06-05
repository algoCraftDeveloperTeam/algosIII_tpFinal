package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 01/06/15.
 */
public class Zealot extends Unit{

    public Zealot() {
        sizeForTransport = 2;
        fieldOfVision = 7;
        trainingCost = new Cost(100, 0);
        trainingTime = 4;
        unitSize = 2;
        life = new Life(100, 60);
    }

    public int getShield() {
        return life.getShield();
    }
}
