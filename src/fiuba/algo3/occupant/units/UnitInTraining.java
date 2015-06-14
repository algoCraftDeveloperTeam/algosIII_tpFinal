package fiuba.algo3.occupant.units;

import fiuba.algo3.exceptions.UnitNotReadyException;

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

    public Unit getUnitBeingTrained() throws UnitNotReadyException {
        if (remainingTurnsToBeTrained > 0){
            throw new UnitNotReadyException();
        }
        return unitToBeTrained;
    }

    public boolean isReady() {
        return this.getRemainingTurns() == 0;
    }
}
