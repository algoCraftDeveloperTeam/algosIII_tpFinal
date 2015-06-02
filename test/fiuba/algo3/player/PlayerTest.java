package fiuba.algo3.player;

import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.BuildingInConstruction;
import fiuba.algo3.buildings.MineralNexus;
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

    @Test
    public void testStartConstructionOfABuildingWithTheRequiredResources() throws Exception {
        // If you call the build method and you have the required resources you
        // receive a BuildingInConstruction. Otherwise you an Error should be
        // raised.
        Building buildingToBeConstructed = new MineralNexus(aPlayer);
        BuildingInConstruction aBuildingInConstruction = this.aPlayer.build(buildingToBeConstructed);
    }

    @Test(expected = Exception.class)
    public void testStartConstructionOfABuildingWithoutTheRequiredResources() throws Exception {
        // TO DO: Create a specific Exception for this situation.
        Building buildingToBeConstructed1 = new Barracks(aPlayer);
        BuildingInConstruction aBuildingInConstruction1 = this.aPlayer.build(buildingToBeConstructed1);
        Building buildingToBeConstructed2 = new Barracks(aPlayer);
        BuildingInConstruction aBuildingInConstruction2 = this.aPlayer.build(buildingToBeConstructed2);
    }
}