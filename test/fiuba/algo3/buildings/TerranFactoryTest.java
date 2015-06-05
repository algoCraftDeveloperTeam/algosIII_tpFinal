package fiuba.algo3.buildings;

import fiuba.algo3.occupant.buildings.TerranFactory;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactoryTest {
    private TerranFactory f;
    @Before
    public void setUp() {
        f = new TerranFactory(new Player());
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(12, f.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(1250, f.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, f.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(100, f.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(200, f.getConstructionCost().getMineralCost());
    }
}