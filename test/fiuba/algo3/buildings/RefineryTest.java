package fiuba.algo3.buildings;

import fiuba.algo3.occupant.buildings.Refinery;
import fiuba.algo3.player.Player;
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
        this.p = new Player();
        this.r = new Refinery(p);
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