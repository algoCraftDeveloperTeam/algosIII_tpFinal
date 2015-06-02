package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 30/05/15.
 */
public class Goliath extends Unit {
    public Goliath(){
        sizeForTransport = 2;
        fieldOfVision = 8;
        trainingTime = 6;
        unitSize = 2;
        life = new Life(125, 0);
        trainingCost = new Cost(100, 50);
    }
}
