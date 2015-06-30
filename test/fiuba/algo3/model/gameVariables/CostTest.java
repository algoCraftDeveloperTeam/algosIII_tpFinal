package fiuba.algo3.model.gameVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class CostTest {

    private Cost aCost;
    @Before
    public void setUp() throws Exception {
        this.aCost = new Cost(10, 20);

    }

    @Test
    public void testGetMineralCost() throws Exception {
        assertEquals(10, aCost.getMineralCost());
    }

    @Test
    public void testGetGasCost() throws Exception {
        assertEquals(20, aCost.getGasCost());
    }
}