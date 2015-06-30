package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class ScienceVesselTest {

    private ScienceVessel aScienceVessel;

    @Before
    public void setUp() throws Exception {

        this.aScienceVessel = new ScienceVessel();
    }

    @Test
    public void testStartingLife() throws Exception {

        assertEquals(200, this.aScienceVessel.getVitality());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(0, this.aScienceVessel.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(10, this.aScienceVessel.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aScienceVesselCost = aScienceVessel.getTrainingCost();
        assertEquals(100, aScienceVesselCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aScienceVesselCost = aScienceVessel.getTrainingCost();
        assertEquals(225, aScienceVesselCost.getGasCost());
    }
}