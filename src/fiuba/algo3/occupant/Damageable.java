package fiuba.algo3.occupant;

import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.occupant.units.CombatUnit;

/**
 * Created by mporto on 05/06/15.
 */
public interface Damageable {

     void receiveDamage(Damage damage);

     boolean isWithinRange(CombatUnit attacker);
}
