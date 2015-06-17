package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mporto on 02/06/15.
 */
public class GoliathTest {

    private Goliath aGoliath;

    @Before
    public void setUp() throws Exception {

        this.aGoliath = new Goliath();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(125, this.aGoliath.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(0, this.aGoliath.getShield());
    }
    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(2, this.aGoliath.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(6, this.aGoliath.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aGolliatCost = aGoliath.getTrainingCost();
        assertEquals(100, aGolliatCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aGolliatCost = aGoliath.getTrainingCost();
        assertEquals(50, aGolliatCost.getGasCost());
    }
}