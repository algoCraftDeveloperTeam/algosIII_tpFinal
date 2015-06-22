package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import org.junit.Before;
import fiuba.algo3.map.AlgoCraftMap;
import org.junit.Test;

/**
 * Created by mporto on 16/06/15.
 */
public class UnitCreatorTest {
    private Player player;
    private Barracks aBarrack;

    @Before
    public void setUp() throws Exception {
        player = new Player(new AlgoCraftMap(20));
        aBarrack = new Barracks(player, new Coordinates(1, 1));

    }

    @Test(expected = UnitNotReadyException.class)
    public void testGetInUnitInTrainingThrowsExceptionWhenUnitIsNotReady() throws UnitNotReadyException {
        aBarrack.trainUnit();
        aBarrack.getUnitInTraining();
    }
}