package fiuba.algo3.units;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class UnitInConstructionTest {

    @Test
    public void testConstructionTimeEqualsToTheOneOfTheUnit() throws Exception {

        Marine aMarine = new Marine();
        UnitInConstruction unitToBeBuilt = new UnitInConstruction(aMarine);

        assertEquals(unitToBeBuilt.getRemainingTurns(), aMarine.getTrainingTime());
    }

    @Test
    public void testConstructionTimeAfterOneTurnEqualsToTheOneOfTheUnitMinusOne() throws Exception {

        Marine aMarine = new Marine();
        UnitInConstruction unitToBeBuilt = new UnitInConstruction(aMarine);
        unitToBeBuilt.passTurn();

        assertEquals(unitToBeBuilt.getRemainingTurns(), aMarine.getTrainingTime() - 1);
    }
}