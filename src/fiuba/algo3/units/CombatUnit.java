package fiuba.algo3.units;

import fiuba.algo3.gameVariables.AttackRange;
import fiuba.algo3.gameVariables.Damage;
import fiuba.algo3.gameVariables.Position;

/**
 * Created by mporto on 04/06/15.
 */
public class CombatUnit extends Unit{

    AttackRange attackRange;
    Damage  damage;

    public void attack(Unit attackedUnit) {
        if(this.isWithinRange(attackedUnit)) {
            // In the meantime the attackedUnit will always receive groundDamage.
            attackedUnit.receiveDamage(damage);
        }else{
            Damage noDamage = new Damage(0, 0);
            attackedUnit.receiveDamage(noDamage);
        }
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

    public boolean isWithinRange(Unit unit) {
        Position unitPosition = unit.getPosition();
        int distanceInX = unitPosition.getX() - this.getPosition().getX();
        int distanceInY = unitPosition.getY() - this.getPosition().getY();
        int distance = (int) Math.sqrt(Math.pow(distanceInX, 2) + Math.pow(distanceInY, 2));

        // In the mean time this will only check with the unit's ground attack range.
        if(distance > this.getGroundAttackRange()){
            return false;
        }else{
            return true;
        }
    }
}
