package fiuba.algo3.gameVariables;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerResourcesTest {

    private PlayerResources pr;
    @Before
    public void setUp() throws Exception {
        this.pr = new PlayerResources(0, 0);
    }

    @Test
    public void testGasInStorageIsZeroWhenInitialized(){
        Assert.assertEquals(this.pr.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageIsZeroWhenInitialized(){
        Assert.assertEquals(this.pr.getMineralStorage(), 0);
    }

    @Test
    public void testAddGas(){
        this.pr.addGas(10);
        Assert.assertEquals(this.pr.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        this.pr.addMinerals(10);
        Assert.assertEquals(this.pr.getMineralStorage(), 10);
    }
}