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
    public void testStartingLife() throws Exception {

        assertEquals(40, this.aMarine.getLife());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(1, this.aMarine.getSizeForTransport());
    }

    @Test
    public void testConstructionTime() throws Exception {

        assertEquals(3, this.aMarine.getConstructionTime());
    }
}