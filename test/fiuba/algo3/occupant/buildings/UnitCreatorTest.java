package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 16/06/15.
 */
public class UnitCreatorTest {
    private Player player;
    private Barracks aBarrack;
    @Before
    public void setUp() throws Exception {
        player = new Player();
        aBarrack = new Barracks(player, 1, 1);

    }

    @Test(expected = UnitNotReadyException.class)
    public void testGetInUnitInTrainingThrowsExceptionWhenUnitIsNotReady() throws UnitNotReadyException {
        aBarrack.trainUnit();
        aBarrack.getUnitInTraining();
    }

    @Test
    public void testGetUnitInTrainingReturnsUnitIfUnitIsReady() throws UnitNotReadyException {
        aBarrack.trainUnit();
        for (int i = 0; i < 3; i++) aBarrack.passTurn();
        aBarrack.getUnitInTraining();
    }
}
