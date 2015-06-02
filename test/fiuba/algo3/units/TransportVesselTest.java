package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class TransportVesselTest {

    private TransportVessel aTransportVessel;

    @Before
    public void setUp() throws Exception {

        this.aTransportVessel = new TransportVessel();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(150, this.aTransportVessel.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(0, this.aTransportVessel.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(0, this.aTransportVessel.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(7, this.aTransportVessel.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aTransportVesselCost = aTransportVessel.getTrainingCost();
        assertEquals(100, aTransportVesselCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aTransportVesselCost = aTransportVessel.getTrainingCost();
        assertEquals(100, aTransportVesselCost.getGasCost());
    }

}