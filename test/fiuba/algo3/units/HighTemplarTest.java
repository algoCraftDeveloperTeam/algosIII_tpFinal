package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class HighTemplarTest {

    private HighTemplar aHighTemplar;

    @Before
    public void setUp() throws Exception {

        this.aHighTemplar = new HighTemplar();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(40, this.aHighTemplar.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(40, this.aHighTemplar.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(2, this.aHighTemplar.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(7, this.aHighTemplar.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aHighTemplarCost = aHighTemplar.getTrainingCost();
        assertEquals(50, aHighTemplarCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aHighTemplarCost = aHighTemplar.getTrainingCost();
        assertEquals(150, aHighTemplarCost.getGasCost());
    }
}