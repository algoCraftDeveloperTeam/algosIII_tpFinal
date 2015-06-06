package fiuba.algo3.occupant.units;

import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.UnitInTraining;
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
        this.unitToBeTrained.passTurn();

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

    @Test
    public void testUnitIsReadyWhenTrainingTimeIsEqualToZero() throws Exception {
        for (int i = 0; i < 3; i++) {
            this.unitToBeTrained.passTurn();
        }

        assertTrue("", this.unitToBeTrained.isReady());
    }
}