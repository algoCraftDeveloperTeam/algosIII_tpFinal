package fiuba.algo3.units;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class UnitInTrainingTest {

    private Marine aMarine;
    private UnitInTraining unitToBeTrained;

    @Before
    public void setUp() throws Exception {
        this.aMarine = new Marine();
        this.unitToBeTrained = new UnitInTraining(aMarine);
    }

    @Test
    public void testTrainingTimeEqualsToTheOneOfTheUnit() throws Exception {
        assertEquals(this.unitToBeTrained.getRemainingTurns(), this.aMarine.getTrainingTime());
    }

    @Test
    public void testTrainingTimeAfterOneTurnEqualsToTheOneOfTheUnitMinusOne() throws Exception {
        unitToBeTrained.passTurn();

        assertEquals(this.unitToBeTrained.getRemainingTurns(), this.aMarine.getTrainingTime() - 1);
    }

    @Test
    public void testGetUnitBeingTrained() throws Exception {
        assertEquals(this.aMarine, this.unitToBeTrained.getUnitBeingTrained());
    }

    @Test
    public void testUnitIsNotReadyWhileTrainingTimeIsGreaterThanZero() throws Exception {
        assertFalse("", this.unitToBeTrained.isReady());
    }

}