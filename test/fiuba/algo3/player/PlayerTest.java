package fiuba.algo3.player;

import fiuba.algo3.occupant.InsufficientResourcesException;
import fiuba.algo3.occupant.buildings.*;
import static org.junit.Assert.*;
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
        assertEquals(this.aPlayer.getGasStorage(), 0);
    }

    @Test
    public void testMineralsInStorageWhenInitialized(){
        assertEquals(this.aPlayer.getMineralStorage(), 200);
    }

    @Test
    public void testAddGas(){
        this.aPlayer.addGas(10);
        assertEquals(this.aPlayer.getGasStorage(), 10);
    }

    @Test
    public void testAddMinerals(){
        this.aPlayer.addMinerals(10);
        assertEquals(this.aPlayer.getMineralStorage(), 210);
    }

    @Test
    public void testStartConstructionOfABuildingWithTheRequiredResources() throws InsufficientResourcesException{
        // If you call the build method and you have the required resources you
        // receive a BuildingInConstruction. Otherwise an Exception should be
        // raised.
        Building buildingToBeConstructed = new MineralNexus(aPlayer);
        BuildingInConstruction aBuildingInConstruction = this.aPlayer.build(buildingToBeConstructed);
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testStartConstructionOfABuildingWithoutTheRequiredResources() throws InsufficientResourcesException {
        Building buildingToBeConstructed1 = new Barracks(aPlayer);
        BuildingInConstruction aBuildingInConstruction1 = this.aPlayer.build(buildingToBeConstructed1);
        Building buildingToBeConstructed2 = new Barracks(aPlayer);
        BuildingInConstruction aBuildingInConstruction2 = this.aPlayer.build(buildingToBeConstructed2);
    }

    @Test
    public void testTerranFactoryCannotBeConstructedWithoutBarracks() {
        assertFalse(this.aPlayer.allowTerranFactory());
    }

    @Test
    public void testTerranFactoryCanBeConstructedWithBarracks() {
        this.aPlayer.addFinishedBuilding(new Barracks(this.aPlayer));
        assertTrue(this.aPlayer.allowTerranFactory());
    }

    @Test
    public void testStargateCannotBeConstructedWithoutAccess() {
        assertFalse(this.aPlayer.allowStargate());
    }

    @Test
    public void testStargateCanBeConstructedWithAccess() {
        this.aPlayer.addFinishedBuilding(new Access(this.aPlayer));
        assertTrue(this.aPlayer.allowStargate());
    }

    @Test
    public void testStarPortCannotBeConstructedWithoutTerranFactory() {
        this.aPlayer.addFinishedBuilding(new Pylon(this.aPlayer));
        assertFalse(this.aPlayer.allowStarPort());
    }

    @Test
    public void testStarPortCanBeConstructedWithTerranFactory() {
        this.aPlayer.addFinishedBuilding(new TerranFactory(this.aPlayer));
        assertTrue(this.aPlayer.allowStarPort());
    }

    @Test
    public void testTemplarArchiveCannotBeConstructedWithoutStargate() {
        assertFalse(this.aPlayer.allowTemplarArchives());
    }

    @Test
    public void testTemplarArchiveCanBeConstructedWithStargate() {
        this.aPlayer.addFinishedBuilding(new Stargate(this.aPlayer));
        assertTrue(this.aPlayer.allowTemplarArchives());
    }

}