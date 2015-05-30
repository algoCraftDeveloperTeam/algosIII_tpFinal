package fiuba.algo3.gameVariables;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class LifeTest {
    @Test
    public void testGetLife() throws Exception {
        Life aLife = new Life(40, 50);

        assertEquals(40, aLife.getVitality());
    }
}