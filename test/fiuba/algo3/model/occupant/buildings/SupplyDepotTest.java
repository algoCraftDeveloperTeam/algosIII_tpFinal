package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mporto on 31/05/15.
 */
public class SupplyDepotTest {

    @Test
    public void testNewSupplyDepotRaisesPlayerAvailablePopulation() throws Exception {
        Player aPlayer = new Player((new AlgoCraftMap(1)).testMap());
        int startingAvailablePopulation = aPlayer.getAvailablePopulation();
        SupplyDepot aSupplyDepot = new SupplyDepot(aPlayer, new Coordinates(0, 0));
        aPlayer.addFinishedBuilding(aSupplyDepot);

        assertEquals(startingAvailablePopulation + 5, aPlayer.getAvailablePopulation());
    }
}