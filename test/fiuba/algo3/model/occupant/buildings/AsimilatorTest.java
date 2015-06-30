package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by nsueiro on 01/06/15.
 */
public class AsimilatorTest {
    private Asimilator asimilator;
    private Player player;
    @Before
    public void setUp(){
        this.player = new Player((new AlgoCraftMap(1)).testMap());
        this.asimilator = new Asimilator(player, new Coordinates(0, 0));
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(450, asimilator.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(450, asimilator.getShield());
    }

    @Test
    public void testAsimilatorAddsGasToOwnersStorage() {
        asimilator.addToPlayerStorage();
        Assert.assertEquals(10, player.getGasStorage());
    }

    @Test
    public void testCanCreate() throws Exception {
        Assert.assertFalse(asimilator.canCreate());

    }
}