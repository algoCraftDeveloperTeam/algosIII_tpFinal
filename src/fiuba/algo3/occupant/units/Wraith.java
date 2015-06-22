package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class Wraith extends CombatUnit{
    public Wraith() {
        sizeForTransport = 0;
        fieldOfVision = 7;
        trainingTime = 8;
        unitSize = 2;
        life = new Life(120, 0);
        trainingCost = new Cost(150, 100);
    }
}
