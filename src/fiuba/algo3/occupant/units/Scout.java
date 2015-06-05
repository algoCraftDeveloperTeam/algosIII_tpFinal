package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.occupant.units.Unit;

/**
 * Created by mporto on 02/06/15.
 */
public class Scout extends Unit {

    public Scout() {
        sizeForTransport = 0;
        fieldOfVision = 7;
        trainingTime = 9;
        unitSize = 3;
        life = new Life(150, 100);
        trainingCost = new Cost(300, 150);
    }
}
