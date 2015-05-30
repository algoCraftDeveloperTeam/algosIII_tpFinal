package fiuba.algo3.gameVariables;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerResourcesTest {
    @Test
    public void testGasInStorageIsZeroWhenInitialized(){
        PlayerResources pr = new PlayerResources();
        Assert.assertEquals(pr.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageIsZeroWhenInitialized(){
        PlayerResources pr = new PlayerResources();
        Assert.assertEquals(pr.getMineralStorage(), 0);
    }

    @Test
    public void testAddGas(){
        PlayerResources pr = new PlayerResources();
        pr.addGas(10);
        Assert.assertEquals(pr.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        PlayerResources pr = new PlayerResources();
        pr.addMinerals(10);
        Assert.assertEquals(pr.getMineralStorage(), 10);
    }
}