package fiuba.algo3.player;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerTest {

    private Player aPlayer;
    @Before
    public void setUp() throws Exception {
        this.aPlayer = new Player();
    }
    @Test
    public void testGasInStorageIsZeroWhenInitialized(){
        Assert.assertEquals(this.aPlayer.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageWhenInitialized(){
        Assert.assertEquals(this.aPlayer.getMineralStorage(), 200);
    }

    @Test
    public void testAddGas(){
        this.aPlayer.addGas(10);
        Assert.assertEquals(this.aPlayer.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        this.aPlayer.addMinerals(10);
        Assert.assertEquals(this.aPlayer.getMineralStorage(), 210);
    }


}