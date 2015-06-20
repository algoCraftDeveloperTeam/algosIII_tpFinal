package fiuba.algo3.integration;

import fiuba.algo3.game.Game;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nsueiro on 19/06/15.
 */
public class NachoTest {
    @Test
    public void testResourceGetterIntegrationTest() throws Exception {
        Game game = new Game();
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
}
