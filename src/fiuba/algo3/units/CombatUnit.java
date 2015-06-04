package fiuba.algo3.units;

import fiuba.algo3.gameVariables.AttackRange;
import fiuba.algo3.gameVariables.Damage;

/**
 * Created by mporto on 04/06/15.
 */
public class CombatUnit extends Unit{

    AttackRange attackRange;
    Damage  damage;

    public void attack(Unit attackedUnit) {
        // In the meantime the attackedUnit will always receive groundDamage.
        attackedUnit.receiveDamage(damage);
    }

    public int getGroundAttackRange() {
        return attackRange.getGroundRange();
    }

    public int getAirAttackRange() {
        return attackRange.getAirRange();
    }

    public int getGroundDamage() {
        return damage.getGroundDamage();
    }

    public int getAirDamage() {
        return damage.getAirDamage();
    }
}
