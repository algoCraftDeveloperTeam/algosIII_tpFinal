package fiuba.algo3.player;

import fiuba.algo3.exceptions.*;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.MineralNexus;
import fiuba.algo3.occupant.buildings.TerranFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerTest {   

    private Player aPlayer;

    @Before
    public void setUp() throws Exception {
        this.aPlayer = new Player(new AlgoCraftMap(100));
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
    public void testStartConstructionOfABuildingWithTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.build(new MineralNexus(this.aPlayer, 99, 99));
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testStartConstructionOfABuildingWithoutTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.build(new Barracks(this.aPlayer, 0, 0));
        this.aPlayer.build(new Barracks(this.aPlayer, 1, 1));
    }

    @Test
    public void testConstructAFactoryHavingBarracksAndTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addGas(100);
        this.aPlayer.addMinerals(200);
        this.aPlayer.addFinishedBuilding(new Barracks(this.aPlayer, 0, 0));
        this.aPlayer.build(new TerranFactory(this.aPlayer, 1, 1));
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testConstructAFactoryHavingBarracksAndWithoutTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addFinishedBuilding(new Barracks(this.aPlayer, 0, 0));
        this.aPlayer.build(new TerranFactory(this.aPlayer, 1, 1));
    }

    @Test(expected = MissingRequiredBuildingsException.class)
    public void testConstructAFactoryNotHavingBarracksAndHavingTheRequiredResources() throws
            InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addGas(100);
        this.aPlayer.addMinerals(200);
        this.aPlayer.build(new TerranFactory(this.aPlayer, 0, 0));
    }
}