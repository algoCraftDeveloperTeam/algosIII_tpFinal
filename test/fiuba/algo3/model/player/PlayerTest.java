package fiuba.algo3.model.player;

import fiuba.algo3.model.exceptions.*;
import fiuba.algo3.model.gameVariables.Damage;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.buildings.*;
import fiuba.algo3.model.occupant.units.Marine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nsueiro on 30/05/15.
 */
public class PlayerTest {   

    private Player aPlayer;
    private SupplyDepot supplyDepot;

    @Before
    public void setUp() throws Exception {
        this.aPlayer = new Player((new AlgoCraftMap(1)).testMap());
        this.supplyDepot = new SupplyDepot(this.aPlayer, new Coordinates(2,2));
        this.aPlayer.addFinishedBuilding(this.supplyDepot);
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
    public void testDestroyingASupplyDepotSubstractsAvailablePopulation(){
        this.supplyDepot.receiveDamage(new Damage(10000, 10000));
        assertEquals(0, this.aPlayer.getAvailablePopulation());
    }

    @Test
    public void testStartConstructionOfABuildingWithTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.build(new MineralNexus(this.aPlayer, new Coordinates(19, 19)));
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testStartConstructionOfABuildingWithoutTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.build(new Barracks(this.aPlayer, new Coordinates(0, 0)));
        this.aPlayer.build(new Barracks(this.aPlayer, new Coordinates(1, 1)));
    }

    @Test
    public void testConstructAFactoryHavingBarracksAndTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addGas(100);
        this.aPlayer.addMinerals(200);
        this.aPlayer.addFinishedBuilding(new Barracks(this.aPlayer, new Coordinates(0, 0)));
        this.aPlayer.build(new TerranFactory(this.aPlayer, new Coordinates(1, 1)));
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testConstructAFactoryHavingBarracksAndWithoutTheRequiredResources()
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addFinishedBuilding(new Barracks(this.aPlayer, new Coordinates(0, 0)));
        this.aPlayer.build(new TerranFactory(this.aPlayer, new Coordinates(1, 1)));
    }

    @Test(expected = MissingRequiredBuildingsException.class)
    public void testConstructAFactoryNotHavingBarracksAndHavingTheRequiredResources() throws
            InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {
        this.aPlayer.addGas(100);
        this.aPlayer.addMinerals(200);
        this.aPlayer.build(new TerranFactory(this.aPlayer, new Coordinates(0, 0)));
    }

    @Test
    public void testStartTrainingOfAMarineWithTheRequirementsMet() throws Exception {
        Barracks barracks = new Barracks(this.aPlayer, new Coordinates(0, 0));
        this.aPlayer.addFinishedBuilding(barracks);
        barracks.trainUnit();
    }

    @Test(expected = InsufficientResourcesException.class)
    public void testStartTrainingOfAMarineWithoutTheRequiredResourcesThrowsInsufficientResourcesException() throws Exception {
        Barracks barracks = new Barracks(this.aPlayer, new Coordinates(0, 0));
        this.aPlayer.addFinishedBuilding(barracks);
        aPlayer.subtractMinerals(200);
        barracks.trainUnit();
    }

    @Test(expected = InsufficientAvailablePopulationException.class)
    public void testStartTrainingOfAMarineWithNotEnoughPopulationRoomThrowsInsufficientAvailablePopulationException() throws Exception {
        Barracks barracks = new Barracks(this.aPlayer, new Coordinates(0, 0));
        this.aPlayer.addFinishedBuilding(barracks);
        this.aPlayer.addMinerals(10000);
        for (int i = 0; i < 25; i++){
            barracks.trainUnit();
        }
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testBuildingAResourceGetterOnAnEarthTileRaisesAnException() throws DestinationIsOccupiedException, MissingRequiredBuildingsException, InsufficientResourcesException, CannotOccupyTileException, KeyDoesNotExistsException {
        ResourceGetter resourceGetter = new MineralCenter(this.aPlayer, new Coordinates(1, 1));
        this.aPlayer.build(resourceGetter);
    }

    @Test
    public void testAPlayerWithAtLeastABuildingIsAlive(){
        Assert.assertTrue(this.aPlayer.isAlive());
    }

    @Test
    public void testAPlayerWithAtLeastAUnitIsAlive(){
        this.aPlayer.removeBuilding(this.supplyDepot);
        this.aPlayer.addUnit(new Marine(), new Coordinates(1,1));
        Assert.assertTrue(this.aPlayer.isAlive());
    }

    @Test
    public void testAPlayerWithAtLeastABuildingInConstructionIsAlive() throws InsufficientResourcesException, CannotOccupyTileException, MissingRequiredBuildingsException, DestinationIsOccupiedException, KeyDoesNotExistsException {
        this.aPlayer.removeBuilding(this.supplyDepot);
        this.aPlayer.build(new SupplyDepot(this.aPlayer, new Coordinates(1, 1)));
        Assert.assertTrue(this.aPlayer.isAlive());
    }

    @Test
    public void testAPlayerWhoOwnsNothingIsDead() {
        this.aPlayer.removeBuilding(this.supplyDepot);
        Assert.assertFalse(this.aPlayer.isAlive());
    }


}
