package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 02/06/15.
 */
public class TerranTransportVessel extends Unit{
    
    int capacity;
    public TerranTransportVessel() {
        sizeForTransport = 0;
        fieldOfVision = 8;
        trainingTime = 7;
        unitSize = 2;
        life = new Life(150, 0);
        trainingCost = new Cost(100, 100);
        capacity = 8;
    }

    public int getCapacity() {
        return capacity;
    }
}
