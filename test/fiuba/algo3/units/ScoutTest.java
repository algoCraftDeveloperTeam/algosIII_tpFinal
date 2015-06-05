package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.occupant.units.Scout;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class ScoutTest {

    private Scout aScout;

    @Before
    public void setUp() throws Exception {

        this.aScout = new Scout();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(150, this.aScout.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(100, this.aScout.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(0, this.aScout.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(9, this.aScout.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aScoutCost = aScout.getTrainingCost();
        assertEquals(300, aScoutCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aScoutCost = aScout.getTrainingCost();
        assertEquals(150, aScoutCost.getGasCost());
    }
}