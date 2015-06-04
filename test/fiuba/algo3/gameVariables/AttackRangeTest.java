package fiuba.algo3.gameVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 04/06/15.
 */
public class AttackRangeTest {

    private AttackRange anAttackRange;
    @Before
    public void setUp() throws Exception {
        this.anAttackRange = new AttackRange(4, 5);
    }

    @Test
    public void testGetGroundRange() throws Exception {
        assertEquals(4, anAttackRange.getGroundRange());
    }

    @Test
    public void testGetAirRange() throws Exception {
        assertEquals(5, anAttackRange.getAirRange());
    }
}