package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.AttackRange;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Life;

/**
 * Created by mporto on 30/05/15.
 */
public class Goliath extends CombatUnit{
    public Goliath(){
        sizeForTransport = 2;
        fieldOfVision = 8;
        trainingTime = 6;
        unitSize = 2;
        life = new Life(125, 0);
        trainingCost = new Cost(100, 50);
        attackRange = new AttackRange(6, 5);
        damage = new Damage(12, 10);
    }
}
