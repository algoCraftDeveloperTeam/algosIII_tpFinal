package fiuba.algo3.buildings;

import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.UnitInTraining;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 01/06/15.
 */
public class BarracksTest {

    private Barracks aBarrack;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player();
        this.aBarrack = new Barracks(owner);
    }

    @Test
    public void testTrainMarineWithRequiredResources() throws Exception {
        UnitInTraining aMarineInTraining = this.aBarrack.trainUnit();

        assertFalse(aMarineInTraining.isReady());
    }
}