package fiuba.algo3.integration;

import fiuba.algo3.game.Game;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 19/06/15.
 */
public class integrationTest {
    private Game game;
    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testResourceGetterIntegrationTest() throws Exception {
        Player player1 = game.getActivePlayer();
        // Initialization tests
        Assert.assertEquals(0, game.getActivePlayer().getGasStorage());
        Assert.assertEquals(200, game.getActivePlayer().getMineralStorage());

        game.build(new MineralCenter(game.getActivePlayer(), new Coordinates(99, 99)));
        // Building something substracts player resources
        Assert.assertEquals(150, game.getActivePlayer().getMineralStorage());

        BuildingInConstruction current = (BuildingInConstruction) game.getAlgoCraftMap().getOccupant(new Coordinates(99, 99));
        // Building is not operational until it's finished
        Assert.assertEquals(4, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());
        game.endTurn();
        // Testing the change of active player
        Assert.assertNotEquals(player1, game.getActivePlayer());
        game.endTurn();
        // Testing the change of active player cycle
        Assert.assertEquals(player1, game.getActivePlayer());
        current = (BuildingInConstruction) game.getAlgoCraftMap().getOccupant(new Coordinates(99, 99));
        Assert.assertEquals(3, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());

        game.endTurn();
        game.endTurn();
        // 2 turns remaining
        game.endTurn();
        game.endTurn();
        // 1 turn remaining
        game.endTurn();
        game.endTurn();
        // Building should be ready
        current = (BuildingInConstruction) game.getAlgoCraftMap().getOccupant(new Coordinates(99, 99));
        Assert.assertTrue(current.isReady());
        Assert.assertEquals(0, current.getRemainingTurns());

        game.endTurn();
        game.endTurn();
        // Resource Getter adds resources to it's owner every turn
        Assert.assertEquals(160, game.getActivePlayer().getMineralStorage());
        game.endTurn();
        game.endTurn();
        Assert.assertEquals(170, game.getActivePlayer().getMineralStorage());
        game.endTurn();
        game.endTurn();
        Assert.assertEquals(180, game.getActivePlayer().getMineralStorage());
    }

    @Test
    public void testGameScenario() throws Exception {
        game.build(new Barracks(game.getActivePlayer(), new Coordinates(1, 1)));

        // Building something substracts player resources
        Assert.assertEquals(50, game.getActivePlayer().getMineralStorage());
        BuildingInConstruction current = (BuildingInConstruction) game.getAlgoCraftMap().getOccupant(new Coordinates(1, 1));

        // Building is not operational until it's finished
        Assert.assertEquals(12, current.getRemainingTurns());
        Assert.assertFalse(current.isReady());
        game.endTurn();

        game.build(new Barracks(game.getActivePlayer(), new Coordinates(4, 4)));

        // I wait for the buildings to be ready.
        for (int i = 0; i < 25; i++) game.endTurn();

        // This line it's a test, because now that the building is ready I should find a Building and not a
        // BuildingInConstruction
        Barracks building = (Barracks) game.getAlgoCraftMap().getOccupant(new Coordinates(1,1));
        building.trainUnit();

        // I wait for the marine to be ready.
        for (int i = 0; i < 100; i++) game.endTurn();

        Marine marine = (Marine) game.getAlgoCraftMap().getOccupant(new Coordinates(0, 0));
        Barracks opponentBuilding = (Barracks) game.getAlgoCraftMap().getOccupant(new Coordinates(4, 4));
        //marine.attack(opponentBuilding);
        //Assert.assertEquals(994, opponentBuilding.getVitality());
    }
}
