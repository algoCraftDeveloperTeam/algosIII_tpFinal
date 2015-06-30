package fiuba.algo3.occupant.buildings;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactoryTest {
    private Player owner;
    private TerranFactory factory;
    @Before
    public void setUp() {
        owner = new Player((new AlgoCraftMap(1)).testMap());
        factory = new TerranFactory(owner, new Coordinates(0, 0));
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(12, factory.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(1250, factory.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, factory.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(100, factory.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(200, factory.getConstructionCost().getMineralCost());
    }

    @Test
    public void testTrainUnit() throws Exception {
        owner.addAvailablePopulation(10);
        owner.addGas(200);
        owner.addMinerals(200);
        factory.trainUnit();
    }
}