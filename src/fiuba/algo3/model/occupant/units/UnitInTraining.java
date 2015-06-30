package fiuba.algo3.model.occupant.units;

import fiuba.algo3.model.exceptions.UnitNotReadyException;
import fiuba.algo3.model.game.TurnAware;

/**
 * Created by mporto on 30/05/15.
 */
public class UnitInTraining implements TurnAware {
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
