package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mporto on 31/05/15.
 */
public class PylonTest {
    private Player owner;
    private int startingAvailablePopulation;
    private Pylon pylon;

    @Before
    public void setUp() throws Exception {
        owner = new Player((new AlgoCraftMap(1)).testMap());
        startingAvailablePopulation = owner.getAvailablePopulation();
        pylon = new Pylon(owner, new Coordinates(0, 0));
    }

    @Test
    public void testNewPylonRaisesPlayerAvailablePopulation() throws Exception {

        assertEquals(startingAvailablePopulation + 5, owner.getAvailablePopulation());
    }
}