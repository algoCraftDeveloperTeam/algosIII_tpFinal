package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Damage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mporto on 16/06/15.
 */
public class UnitTest {
    @Test
    public void testPassTurnOnAUnitWithShieldRegeneratesItsShield() throws Exception {
        Unit aZealot = new Zealot();
        Damage damage = new Damage(20, 0);
        aZealot.receiveDamage(damage);
        aZealot.passTurn();
        // 60 (Zealot initial shield) - 20 + 10 (shield regeneration shield) = 50
        int remainingShieldExpected = 50;

        Assert.assertEquals(remainingShieldExpected, aZealot.getShield());

    }
}
