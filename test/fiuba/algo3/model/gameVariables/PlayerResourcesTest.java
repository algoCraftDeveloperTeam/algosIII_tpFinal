package fiuba.algo3.model.gameVariables;

import fiuba.algo3.model.exceptions.SubtractedResourcesGreaterThanStoragedException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerResourcesTest {

    private PlayerResources playerResources;
    @Before
    public void setUp() throws Exception {
        this.playerResources = new PlayerResources(0, 0);
    }

    @Test
    public void testGasInStorageIsZeroWhenInitialized(){
        Assert.assertEquals(this.playerResources.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageIsZeroWhenInitialized(){
        Assert.assertEquals(this.playerResources.getMineralStorage(), 0);
    }

    @Test
    public void testAddGas(){
        this.playerResources.addGas(10);
        Assert.assertEquals(this.playerResources.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        this.playerResources.addMinerals(10);
        Assert.assertEquals(this.playerResources.getMineralStorage(), 10);
    }

    @Test
    public void testSubtractGas() throws Exception {
        this.playerResources.addGas(15);
        this.playerResources.subtractGas(10);
        Assert.assertEquals(this.playerResources.getGasStorage(), 5);
    }

    @Test
    public void testSubstractMinerals() throws Exception {
        this.playerResources.addMinerals(15);
        this.playerResources.subtractMinerals(10);
        Assert.assertEquals(this.playerResources.getMineralStorage(), 5);
    }

    @Test (expected = SubtractedResourcesGreaterThanStoragedException.class)
    public void testSubstractMoreResourcesThanAllowed() throws SubtractedResourcesGreaterThanStoragedException {
        this.playerResources.subtractResources(new Cost(1000, 1000));
    }
}