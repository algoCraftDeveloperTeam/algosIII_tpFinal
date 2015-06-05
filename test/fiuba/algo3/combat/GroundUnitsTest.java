package fiuba.algo3.combat;

import fiuba.algo3.occupant.units.CombatUnit;
import fiuba.algo3.occupant.units.Goliath;
import fiuba.algo3.occupant.units.Marine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 04/06/15.
 */
public class GroundUnitsTest {
    
    private CombatUnit marine;
    private CombatUnit goliath;
    
    @Before
    public void setUp() throws Exception {
        marine = new Marine(); 
        goliath = new Goliath();
    }

    @Test
    public void testMarineAttacksGoliathWithinRange() throws Exception {
        marine.move(1, 1);
        goliath.move(2, 2);
        marine.attack(goliath);
        // 125 (goliath's vitality) - 6 (marine's attack) = 119
        int expectedRemainingVitality = 119;

        Assert.assertEquals(expectedRemainingVitality, goliath.getVitality());
    }

    @Test
    public void testMarineAttacksGoliathsOutsideRange() throws Exception {
        marine.move(11, 11);
        goliath.move(15, 16);
        marine.attack(goliath);

        Assert.assertEquals(125, goliath.getVitality());
    }

    @Test
    public void testGoliathAttacksMarine() throws Exception {
        goliath.attack(marine);
        // 40 (marine's vitality - 12 (goliat's attack) = 28
        int expectedRemainingVitality = 28;

        Assert.assertEquals(expectedRemainingVitality, marine.getVitality());
    }
}
