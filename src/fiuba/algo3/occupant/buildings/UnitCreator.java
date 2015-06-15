package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.occupant.units.Unit;

/**
 * Created by nsueiro on 03/06/15.
 */
public interface UnitCreator {
    void trainUnit();

    Unit getUnitInTraining() throws UnitNotReadyException;
}
