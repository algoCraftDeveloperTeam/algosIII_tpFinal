package fiuba.algo3.occupant.buildings;

import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import fiuba.algo3.map.AlgoCraftMap;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class MineralNexusTest {
    private MineralNexus mn;
    private Player p;
    @Before
    public void setUp(){
        this.p = new Player(new AlgoCraftMap(20));
        this.mn = new MineralNexus(p, new Coordinates(0, 0));
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(250, mn.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(250, mn.getShield());
    }

    @Test
    public void testMineralNexusAddsMineralsToOwnersStorage() {
        mn.addToPlayerStorage();
        Assert.assertEquals(210, p.getMineralStorage());
    }

}