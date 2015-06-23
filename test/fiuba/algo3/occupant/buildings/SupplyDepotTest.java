package fiuba.algo3.occupant.buildings;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mporto on 31/05/15.
 */
public class SupplyDepotTest {

    @Test
    public void testNewSupplyDepotRaisesPlayerAvailablePopulation() throws Exception {
        Player aPlayer = new Player(AlgoCraftMap.generateTestMap());
        int startingAvailablePopulation = aPlayer.getAvailablePopulation();
        SupplyDepot aSupplyDepot = new SupplyDepot(aPlayer, new Coordinates(0, 0));

        assertEquals(startingAvailablePopulation + 5, aPlayer.getAvailablePopulation());
    }
}