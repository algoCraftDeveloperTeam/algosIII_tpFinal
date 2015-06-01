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

    @Test
    public void testAttackReducesShield() {
        this.aLife.receiveAttack(20);
        assertEquals(30, this.aLife.getShield());
    }

    @Test
    public void testAttackDoesNotReduceVitality() {
        this.aLife.receiveAttack(20);
        assertEquals(40, this.aLife.getVitality());
    }

    @Test
    public void testRegenerateShield() {
        this.aLife.receiveAttack(20);
        this.aLife.regenerateShield();
        assertEquals(40, this.aLife.getShield());
    }

    @Test
    public void testAttackGreaterThanShieldReducesVitality() {
        this.aLife.receiveAttack(60);
        assertEquals(30, this.aLife.getVitality());
    }

    @Test
    public void testABrokenShieldCannotRegenerate() {
        this.aLife.receiveAttack(60);
        this.aLife.regenerateShield();
        assertEquals(0, this.aLife.getShield());
    }

    @Test
    public void testShieldCannotRegeneratePastItsMaxValue() {
        this.aLife.receiveAttack(5);
        this.aLife.regenerateShield();
        assertEquals(50, this.aLife.getShield());
    }
}