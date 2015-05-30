package fiuba.algo3.units;

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
    public void testStartingLifeEqualsTo40() throws Exception {

        assertEquals(40, this.aMarine.getLife());
    }

    @Test
    public void testSizeForTransportEqualsTo1() throws Exception {

        assertEquals(1, this.aMarine.getSizeForTransport());
    }

    @Test
    public void testConstructionTimeEqualsTo3() throws Exception {

        assertEquals(3, this.aMarine.getConstructionTime());
    }
}