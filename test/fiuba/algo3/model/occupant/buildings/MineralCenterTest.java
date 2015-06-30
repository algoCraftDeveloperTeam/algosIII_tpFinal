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
public class MineralCenterTest {
    private MineralCenter mc;
    private Player p;
    @Before
    public void setUp(){
        this.p = new Player((new AlgoCraftMap(1)).testMap());
        this.mc = new MineralCenter(p, new Coordinates(0, 0));
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(500, mc.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(0, mc.getShield());
    }

    @Test
    public void testMineralNexusAddsMineralsToOwnersStorage() {
        mc.addToPlayerStorage();
        Assert.assertEquals(210, p.getMineralStorage());
    }

}