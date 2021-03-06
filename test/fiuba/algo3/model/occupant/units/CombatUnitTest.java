package fiuba.algo3.model.occupant.units;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 04/06/15.
 */
public class CombatUnitTest {

    private CombatUnit goliath;
    @Before
    public void setUp() throws Exception {
       goliath = new Goliath();
    }

    @Test
    public void testGroundAttackRange() throws Exception {
        Assert.assertEquals(6, goliath.getGroundAttackRange());
    }

    @Test
    public void testAirAttackRange() throws Exception {
        Assert.assertEquals(5, goliath.getAirAttackRange());
    }
    @Test
    public void testGroundDamage() throws Exception {
        Assert.assertEquals(12, goliath.getGroundDamage());
    }

    @Test
    public void testAirDamage() throws Exception {
        Assert.assertEquals(10, goliath.getAirDamage());
    }

    @Test
    public void testCanAttack() throws Exception {
        Assert.assertTrue(goliath.canAttack());
    }
}