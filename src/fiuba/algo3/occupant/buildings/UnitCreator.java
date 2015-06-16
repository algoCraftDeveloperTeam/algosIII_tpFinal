package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;

/**
 * Created by nsueiro on 03/06/15.
 */
public interface UnitCreator {
    void trainUnit();

    void getUnitInTraining() throws UnitNotReadyException;
}
