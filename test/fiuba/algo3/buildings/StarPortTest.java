package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class StarPortTest {
    private StarPort sp;
    @Before
    public void setUp() {
        sp = new StarPort(new Player());
    }

    @Test
    public void testIsEarthBuildable() {
        Assert.assertTrue(sp.isEarthBuildable());
    }

    @Test
    public void testIsGasBuildable() {
        Assert.assertFalse(sp.isGasBuildable());
    }

    @Test
    public void testIsMineralBuildable() {
        Assert.assertFalse(sp.isMineralBuildable());
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(10, sp.getConstructionTime());
    }
    
    @Test
    public void testGetVitality() {
        Assert.assertEquals(1300, sp.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, sp.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(100, sp.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(150, sp.getConstructionCost().getMineralCost());
    }
}