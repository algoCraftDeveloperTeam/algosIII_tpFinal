package fiuba.algo3.occupant.units;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.occupant.units.Dragon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 02/06/15.
 */
public class DragonTest {

    private Dragon aDragon;

    @Before
    public void setUp() throws Exception {

        this.aDragon = new Dragon();
    }

    @Test
    public void testStartingVitality() throws Exception {

        assertEquals(100, this.aDragon.getVitality());
    }

    @Test
    public void testStartingShield() throws Exception {

        assertEquals(80, this.aDragon.getShield());
    }

    @Test
    public void testSizeForTransport() throws Exception {

        assertEquals(4, this.aDragon.getSizeForTransport());
    }

    @Test
    public void testTrainingTime() throws Exception {

        assertEquals(6, this.aDragon.getTrainingTime());
    }

    @Test
    public void testMineralTrainingCost() throws Exception {
        Cost aDragonCost = aDragon.getTrainingCost();
        assertEquals(125, aDragonCost.getMineralCost());
    }

    @Test
    public void testGasTrainingCost() throws Exception {
        Cost aDragonCost = aDragon.getTrainingCost();
        assertEquals(50, aDragonCost.getGasCost());
    }
}