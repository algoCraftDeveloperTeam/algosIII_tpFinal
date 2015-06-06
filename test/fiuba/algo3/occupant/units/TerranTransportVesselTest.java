package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.occupant.units.TerranTransportVessel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class TerranTransportVesselTest {

    private TerranTransportVessel aTerranTransportVessel;

    @Before
    public void setUp() throws Exception {

        this.aTerranTransportVessel = new TerranTransportVessel();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(150, this.aTerranTransportVessel.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(0, this.aTerranTransportVessel.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(0, this.aTerranTransportVessel.getSizeForTransport());
    }

    @Test
    public void testCapacity() throws Exception {

        assertEquals(8, this.aTerranTransportVessel.getCapacity());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(7, this.aTerranTransportVessel.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aTransportVesselCost = aTerranTransportVessel.getTrainingCost();
        assertEquals(100, aTransportVesselCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aTransportVesselCost = aTerranTransportVessel.getTrainingCost();
        assertEquals(100, aTransportVesselCost.getGasCost());
    }

}