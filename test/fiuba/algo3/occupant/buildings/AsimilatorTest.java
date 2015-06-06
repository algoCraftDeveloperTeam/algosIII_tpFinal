package fiuba.algo3.occupant.buildings;

import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class AsimilatorTest {
    private Asimilator a;
    private Player p;
    @Before
    public void setUp(){
        this.p = new Player();
        this.a = new Asimilator(p);
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(450, a.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(450, a.getShield());
    }

    @Test
    public void testAsimilatorAddsGasToOwnersStorage() {
        a.addToPlayerStorage();
        Assert.assertEquals(10, p.getGasStorage());
    }

}