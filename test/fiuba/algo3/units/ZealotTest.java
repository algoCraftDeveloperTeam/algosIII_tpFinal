package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.occupant.units.Zealot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 01/06/15.
 */
public class ZealotTest {

    private Zealot aZealot;

    @Before
    public void setUp() throws Exception {

        this.aZealot = new Zealot();
    }

    @Test
    public void testStartingVitality() throws Exception {
        assertEquals(100, this.aZealot.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {
        assertEquals(60, this.aZealot.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(2, this.aZealot.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(4, this.aZealot.getTrainingTime());
    }

    @Test
    public void testTrainingCost() throws Exception {
        Cost aZealotCost = aZealot.getTrainingCost();
        assertEquals(100, aZealotCost.getMineralCost());
    }
}