package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class WraithTest {

    private Wraith aWraith;

    @Before
    public void setUp() throws Exception {

        this.aWraith = new Wraith();
    }

    @Test
    public void testStartingLife() throws Exception {

        assertEquals(120, this.aWraith.getVitality());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(0, this.aWraith.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(8, this.aWraith.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aGolliatCost = aWraith.getTrainingCost();
        assertEquals(150, aGolliatCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aGolliatCost = aWraith.getTrainingCost();
        assertEquals(100, aGolliatCost.getGasCost());
    }

}