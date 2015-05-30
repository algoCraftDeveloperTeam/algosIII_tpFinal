package fiuba.algo3.units;

/**
 * Created by mporto on 30/05/15.
 */
public class UnitInConstruction {
    private Unit unitToBeBuilt;
    private int remainingTurnsToBeBuilt;

    public UnitInConstruction(Unit unit) {
        unitToBeBuilt = unit;
        remainingTurnsToBeBuilt = unit.getConstructionTime();
    }

    public int getRemainingTurns() {
        return remainingTurnsToBeBuilt;
    }

    public void passTurn() {
        remainingTurnsToBeBuilt--;
    }
}
