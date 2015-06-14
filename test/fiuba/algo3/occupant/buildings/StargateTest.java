package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class StargateTest {

    private Stargate aStargate;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player();
        this.aStargate = new Stargate(owner, 0, 0);
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(10, aStargate.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(600, aStargate.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(600, aStargate.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(150, aStargate.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(150, aStargate.getConstructionCost().getMineralCost());
    }

}