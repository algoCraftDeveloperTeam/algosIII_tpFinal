package fiuba.algo3.units;

import fiuba.algo3.gameVariables.Cost;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mporto on 28/05/15.
 */
public class MarineTest {

    private Marine aMarine;

    @Before
    public void setUp() throws Exception {

        this.aMarine = new Marine();
    }

    @Test
    public void testStartingLife() throws Exception {

        assertEquals(40, this.aMarine.getLife());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(1, this.aMarine.getSizeForTransport());
    }

    @Test
    public void testConstructionTime() throws Exception {

        assertEquals(3, this.aMarine.getTrainingTime());
    }

    @Test
    public void testTrainingCost() throws Exception {
        Cost aMarineCost = aMarine.getTrainingCost();
        assertEquals(50, aMarineCost.getMineralCost());
    }
}