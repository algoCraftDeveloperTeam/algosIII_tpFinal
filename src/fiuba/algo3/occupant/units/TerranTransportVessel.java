package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;

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

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
        Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > attacker.getAirAttackRange());
    }
}
