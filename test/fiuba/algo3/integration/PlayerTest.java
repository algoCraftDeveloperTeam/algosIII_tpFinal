package fiuba.algo3.integration;

import fiuba.algo3.exceptions.*;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.buildings.ResourceGetter;
import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 17/06/15.
 */
public class PlayerTest {
    private Player player;

    @Before
    public void setUp() {
        player = new Player(new AlgoCraftMap(100));
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testBuildingAResourceGetterOnAnEarthTileRaisesAnException() throws DestinationIsOccupiedException, MissingRequiredBuildingsException, InsufficientResourcesException, CannotOccupyTileException, KeyDoesNotExistsException {
        ResourceGetter resourceGetter = new MineralCenter(this.player, new Coordinates(1, 1));
        this.player.build(resourceGetter);
    }
}
