package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class RefineryTest {
    private Refinery r;
    private Player p;
    @Before
    public void setUp(){
        this.p = new Player((new AlgoCraftMap(1)).testMap());
        this.r = new Refinery(p, new Coordinates(0, 0));
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(750, r.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, r.getShield());
    }

    @Test
    public void testRefineryAddsGasToOwnersStorage() {
        r.addToPlayerStorage();
        Assert.assertEquals(10, p.getGasStorage());
    }

}