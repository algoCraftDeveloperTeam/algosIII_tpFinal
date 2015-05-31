package fiuba.algo3.gameVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class LifeTest {

    private Life aLife;

    @Before
    public void setUp() throws Exception {
        this.aLife = new Life(40, 50);
    }

    @Test
    public void testGetLife() throws Exception {
        assertEquals(40, this.aLife.getVitality());
    }
}