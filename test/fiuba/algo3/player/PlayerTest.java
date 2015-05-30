package fiuba.algo3.player;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerTest {

    @Test
    public void testGasInStorageIsZeroWhenInitialized(){
        Player p = new Player();
        Assert.assertEquals(p.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageIsZeroWhenInitialized(){
        Player p = new Player();
        Assert.assertEquals(p.getMineralStorage(), 0);
    }

    @Test
    public void testAddGas(){
        Player p = new Player();
        p.addGas(10);
        Assert.assertEquals(p.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        Player p = new Player();
        p.addMinerals(10);
        Assert.assertEquals(p.getMineralStorage(), 10);
    }
}