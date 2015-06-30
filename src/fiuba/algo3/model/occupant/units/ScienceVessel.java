package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Life;
import fiuba.algo3.model.map.Coordinates;

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
        info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
    }

    @Override
    public boolean isWithinRange(CombatUnit attacker) {
        Coordinates unitPosition = attacker.getPosition();
        int distance = this.position.distance(unitPosition);
        // In the meantime this will only check with the unit's ground attack range.
        return !(distance > attacker.getAirAttackRange());
    }
}
