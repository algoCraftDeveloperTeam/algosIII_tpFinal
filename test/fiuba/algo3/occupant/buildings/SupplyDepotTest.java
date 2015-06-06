package fiuba.algo3.occupant.buildings;

import fiuba.algo3.occupant.buildings.SupplyDepot;
import fiuba.algo3.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 31/05/15.
 */
public class SupplyDepotTest {

    @Test
    public void testNewSupplyDepotRaisesPlayerAvailablePopulation() throws Exception {
        Player aPlayer = new Player();
        int startingAvailablePopulation = aPlayer.getAvailablePopulation();
        SupplyDepot aSupplyDepot = new SupplyDepot(aPlayer);

        assertEquals(startingAvailablePopulation + 5, aPlayer.getAvailablePopulation());
    }
}