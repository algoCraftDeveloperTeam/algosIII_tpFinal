package fiuba.algo3.game;

import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 17/06/15.
 */
public class GameTest {

    //private AlgoCraftMap algoCraftMap;
    private Game game;
    //private Player player1, player2;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void testEndTurnCausesToChangeActivePlayer() throws Exception {
        Player oldActivePlayer = game.getActivePlayer();
        game.endTurn();
        Player newActivePlayer = game.getActivePlayer();

        Assert.assertNotEquals(oldActivePlayer, newActivePlayer);
    }

    @Test
    public void testBuildingInConstructionRemainingTurnsReducesInOneWhenAWholeTurnPasses() throws Exception {
        Building barrack = new Barracks(game.getActivePlayer(), 1, 1);
        game.endTurn();
        game.endTurn();


    }
}