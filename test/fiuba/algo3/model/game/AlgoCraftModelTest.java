package fiuba.algo3.model.game;

import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.occupant.buildings.Barracks;
import fiuba.algo3.model.occupant.buildings.Building;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 17/06/15.
 */
public class AlgoCraftModelTest {

    private AlgoCraftModel algoCraftModel;

    @Before
    public void setUp() throws Exception {
        algoCraftModel = new AlgoCraftModel();
    }

    @Test
    public void testEndTurnCausesToChangeActivePlayer() throws Exception {
        Player oldActivePlayer = algoCraftModel.getActivePlayer();
        algoCraftModel.endTurn();
        Player newActivePlayer = algoCraftModel.getActivePlayer();

        Assert.assertNotSame(oldActivePlayer, newActivePlayer);
    }

    @Test
    public void testBuildingInConstructionRemainingTurnsReducesInOneWhenAWholeTurnPasses() throws Exception {
        Building barrack = new Barracks(algoCraftModel.getActivePlayer(), new Coordinates(1, 1));
        algoCraftModel.endTurn();
        algoCraftModel.endTurn();


    }
}