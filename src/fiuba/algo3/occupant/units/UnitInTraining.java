package fiuba.algo3.occupant.units;

/**
 * Created by mporto on 30/05/15.
 */
public class UnitInTraining {
    private Unit unitToBeTrained;
    private int remainingTurnsToBeTrained;

    public UnitInTraining(Unit unit) {
        unitToBeTrained = unit;
        remainingTurnsToBeTrained = unit.getTrainingTime();
    }

    public int getRemainingTurns() {
        return remainingTurnsToBeTrained;
    }

    public void passTurn() {
        remainingTurnsToBeTrained--;
    }

    public Unit getUnitBeingTrained() {
        return unitToBeTrained;
    }

    public boolean isReady() {
        return this.getRemainingTurns() == 0;
    }
}
