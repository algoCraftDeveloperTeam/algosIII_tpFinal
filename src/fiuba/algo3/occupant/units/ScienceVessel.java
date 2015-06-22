package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;

/**
 * Created by mporto on 02/06/15.
 */
public class ScienceVessel extends Unit{
    public ScienceVessel() {
        sizeForTransport = 0;
        fieldOfVision = 10;
        trainingTime = 10;
        unitSize = 2;
        life = new Life(200, 0);
        trainingCost = new Cost(100, 225);
    }

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
        Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > attacker.getAirAttackRange());
    }
}
