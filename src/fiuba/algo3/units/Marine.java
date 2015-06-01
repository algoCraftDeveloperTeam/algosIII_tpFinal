package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 28/05/15.
 */
public class Marine extends Unit{

    public Marine() {
        sizeForTransport = 1;
        fieldOfVision = 7;
        trainingCost = new Cost(50, 0);
        trainingTime = 3;
        unitSize = 1;
        life = new Life(40, 0);
    }


}
