package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;

/**
 * Created by mporto on 01/06/15.
 */
public class Zealot extends CombatUnit{


    public Zealot() {
        sizeForTransport = 2;
        fieldOfVision = 7;
        trainingCost = new Cost(100, 0);
        trainingTime = 4;
        unitSize = 2;
        life = new Life(100, 60);
        info = "Zealot";
    }

    public int getShield() {
        return life.getShield();
    }
}
