package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;
import org.junit.Test;
import fiuba.algo3.map.AlgoCraftMap;

import static org.junit.Assert.*;

/**
 * Created by mporto on 31/05/15.
 */
public class PylonTest {

    @Test
    public void testNewPylonRaisesPlayerAvailablePopulation() throws Exception {
        Player aPlayer = new Player(new AlgoCraftMap(20));
        int startingAvailablePopulation = aPlayer.getAvailablePopulation();
        Pylon aPylon = new Pylon(aPlayer, 0, 0);

        assertEquals(startingAvailablePopulation + 5, aPlayer.getAvailablePopulation());
    }
}