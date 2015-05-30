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
    public void testAddGas() throws Exception {

    }

    @Test
    public void testAddMinerals() throws Exception {

    }
}