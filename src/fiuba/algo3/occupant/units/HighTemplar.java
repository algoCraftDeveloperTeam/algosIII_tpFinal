package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class HighTemplar extends Unit{

    public HighTemplar() {
        sizeForTransport = 2;
        fieldOfVision = 7;
        trainingTime = 7;
        unitSize = 2;
        life = new Life(40, 40);
        trainingCost = new Cost(50, 150);
    }
}
