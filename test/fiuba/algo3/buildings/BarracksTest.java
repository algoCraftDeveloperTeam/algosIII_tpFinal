package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 01/06/15.
 */
public class BarracksTest {

    private Barracks aBarrack;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player();
        this.aBarrack = new Barracks(owner);
    }

    @Test
    public void testTrainMarine() throws Exception {
        assertTrue(true);

    }
}