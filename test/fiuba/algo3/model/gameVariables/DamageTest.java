package fiuba.algo3.model.gameVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 04/06/15.
 */
public class DamageTest {

    private Damage aDamage;

    @Before
    public void setUp() throws Exception {
        this.aDamage = new Damage(6, 9);
    }

    @Test
    public void testGetGroundDamage() throws Exception {
        assertEquals(6, aDamage.getGroundDamage());
    }

    @Test
    public void testGetAirDamage() throws Exception {
        assertEquals(9, aDamage.getAirDamage());
    }
}