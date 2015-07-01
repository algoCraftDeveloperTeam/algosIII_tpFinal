package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.AttackRange;
import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.gameVariables.Life;

/**
 * Created by mporto on 28/05/15.
 */
public class Marine extends CombatUnit{



    public Marine() {
        sizeForTransport = 1;
        fieldOfVision = 7;
        trainingCost = new Cost(50, 0);
        trainingTime = 3;
        unitSize = 1;
        life = new Life(40, 0);
        attackRange = new AttackRange(4, 4);
        damage = new Damage(6, 6);
        info = "Marine";
    }


}
