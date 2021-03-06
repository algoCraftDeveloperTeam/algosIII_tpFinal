package fiuba.algo3.integration;

import fiuba.algo3.model.game.AlgoCraftModel;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.occupant.Damageable;
import fiuba.algo3.model.occupant.buildings.Barracks;
import fiuba.algo3.model.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.model.occupant.buildings.MineralCenter;
import fiuba.algo3.model.occupant.buildings.SupplyDepot;
import fiuba.algo3.model.occupant.units.Marine;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 19/06/15.
 */
public class integrationTest {
    private AlgoCraftModel algoCraftModel;
    @Before
    public void setUp() throws Exception {
        algoCraftModel = new AlgoCraftModel();
        AlgoCraftMap algoCraftMap = algoCraftModel.getAlgoCraftMap();
        algoCraftMap.testMap();
    }

    @Test
    public void testResourceGetterIntegrationTest() throws Exception {
        Player player1 = algoCraftModel.getActivePlayer();
        // Initialization tests
        Assert.assertEquals(0, algoCraftModel.getActivePlayer().getGasStorage());
        Assert.assertEquals(400, algoCraftModel.getActivePlayer().getMineralStorage());

        algoCraftModel.build(new MineralCenter(algoCraftModel.getActivePlayer(), new Coordinates(19, 19)));
        // Building something substracts player resources
        Assert.assertEquals(350, algoCraftModel.getActivePlayer().getMineralStorage());

        BuildingInConstruction current = (BuildingInConstruction) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(19, 19));
        // Building is not operational until it's finished
        Assert.assertEquals(4, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());
        algoCraftModel.endTurn();
        // Testing the change of active player
        Assert.assertNotSame(player1, algoCraftModel.getActivePlayer());
        algoCraftModel.endTurn();
        // Testing the change of active player cycle
        Assert.assertEquals(player1, algoCraftModel.getActivePlayer());
        current = (BuildingInConstruction) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(19, 19));
        Assert.assertEquals(3, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());

        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        // 2 turns remaining
        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        // 1 turn remaining
        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        // Building should be ready
        current = (BuildingInConstruction) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(19, 19));
        Assert.assertTrue(current.isReady());
        Assert.assertEquals(0, current.getRemainingTurns());

        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        // Resource Getter adds resources to it's owner every turn
        Assert.assertEquals(360, algoCraftModel.getActivePlayer().getMineralStorage());
        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        Assert.assertEquals(370, algoCraftModel.getActivePlayer().getMineralStorage());
        algoCraftModel.endTurn();
        algoCraftModel.endTurn();
        Assert.assertEquals(380, algoCraftModel.getActivePlayer().getMineralStorage());
    }

    @Test
    public void testAlgoCraftModelScenario() throws Exception {
        algoCraftModel.build(new SupplyDepot(algoCraftModel.getActivePlayer(), new Coordinates(5, 5)));
        algoCraftModel.build(new Barracks(algoCraftModel.getActivePlayer(), new Coordinates(1, 1)));

        // Building something substracts player resources
        Assert.assertEquals(150, algoCraftModel.getActivePlayer().getMineralStorage());
        BuildingInConstruction current = (BuildingInConstruction) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(1, 1));

        // Building is not operational until it's finished
        Assert.assertEquals(12, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());
        algoCraftModel.endTurn();

        algoCraftModel.build(new SupplyDepot(algoCraftModel.getActivePlayer(), new Coordinates(4, 4)));
        algoCraftModel.build(new Barracks(algoCraftModel.getActivePlayer(), new Coordinates(2, 2)));

        // I wait for the buildings to be ready.
        for (int i = 0; i < 25; i++) algoCraftModel.endTurn();

        // This line it's a test, because now that the building is ready I should find a Building and not a
        // BuildingInConstruction
        Barracks building = (Barracks) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(1,1));
        building.trainUnit();

        // I wait for the marine to be ready.
        for (int i = 0; i < 100; i++) algoCraftModel.endTurn();

        Marine marine = (Marine) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(0, 0));
        Barracks opponentBuilding = (Barracks) algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(2, 2));
        marine.attack(opponentBuilding);
        Assert.assertEquals(994, opponentBuilding.getVitality());
    }

    public void testDeadBuildingsAndUnitsAreRemovedFromMap() throws Exception{
        this.algoCraftModel.build(new Barracks(this.algoCraftModel.getActivePlayer(), new Coordinates(1, 1)));
        this.algoCraftModel.endTurn();
        this.algoCraftModel.build(new Barracks(this.algoCraftModel.getActivePlayer(), new Coordinates(1, 2)));
        this.algoCraftModel.endTurn();
        for(int i = 0; i < 20; i++){
            this.algoCraftModel.endTurn();
        }
        Marine marine = (Marine) this.algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(0, 0));
        for(int i = 0; i < 167; i++){
            marine.attack((Damageable) this.algoCraftModel.getAlgoCraftMap().getOccupant(new Coordinates(1, 2)));
            this.algoCraftModel.endTurn();
            this.algoCraftModel.endTurn();
        }
        Assert.assertFalse(this.algoCraftModel.getAlgoCraftMap().isOccupied(new Coordinates(1, 2)));
    }
}
