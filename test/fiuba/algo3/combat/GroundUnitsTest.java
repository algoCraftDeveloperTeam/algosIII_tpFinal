package fiuba.algo3.combat;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
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
    private AlgoCraftMap algoCraftMap;
    
    @Before
    public void setUp() throws Exception {
        marine = new Marine(); 
        goliath = new Goliath();
        algoCraftMap = new AlgoCraftMap(20);
    }

    @Test
    public void testMarineAttacksGoliathWithinRange() throws Exception {
        marine.setPosition(algoCraftMap, new Coordinates(2,3));
        goliath.setPosition(algoCraftMap, new Coordinates(4,5));
        marine.attack(goliath);
        // 125 (goliath's vitality) - 6 (marine's attack) = 119
        Assert.assertEquals(119, goliath.getVitality());
    }

    @Test
    public void testMarineAttacksGoliathsOutsideRange() throws Exception {
        marine.setPosition(algoCraftMap, new Coordinates(1,1));
        goliath.setPosition(algoCraftMap, new Coordinates(9,9));
        marine.attack(goliath);
        
        Assert.assertEquals(125, goliath.getVitality());
    }

    @Test
    public void testGoliathAttacksMarine() throws Exception {
        marine.setPosition(algoCraftMap, new Coordinates(2,3));
        goliath.setPosition(algoCraftMap, new Coordinates(4,5));
        goliath.attack(marine);
        // 40 (marine's vitality) - 12 (goliath's attack) = 28
        Assert.assertEquals(28, marine.getVitality());
    }
}
