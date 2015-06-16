package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;
import fiuba.algo3.map.AlgoCraftMap;

import org.junit.Assert;

public class AccessTest {

    private Access aAccess;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player(new AlgoCraftMap(20));
        this.aAccess = new Access(owner, 0, 0);
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

}