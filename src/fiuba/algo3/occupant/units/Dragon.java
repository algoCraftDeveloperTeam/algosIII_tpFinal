package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class Dragon extends Unit{

    public Dragon() {
        sizeForTransport = 4;
        fieldOfVision = 8;
        trainingTime = 6;
        unitSize = 2;
        life = new Life(100, 80);
        trainingCost = new Cost(125, 50);
    }
}
