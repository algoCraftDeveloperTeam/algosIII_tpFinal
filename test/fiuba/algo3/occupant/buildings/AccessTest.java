package fiuba.algo3.occupant.buildings;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccessTest {

    private Access aAccess;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player((new AlgoCraftMap(1)).testMap());
        this.aAccess = new Access(owner, new Coordinates(0, 0));
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(8, aAccess.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(500, aAccess.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(500, aAccess.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(0, aAccess.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(150, aAccess.getConstructionCost().getMineralCost());
    }

    @Test
    public void testTrainUnitTest() throws Exception {
        owner.addAvailablePopulation(10);
        aAccess.trainUnit();
    }
}