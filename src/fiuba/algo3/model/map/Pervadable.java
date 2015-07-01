package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.NotEnoughRoomException;
import fiuba.algo3.model.occupant.Occupant;

public interface Pervadable {

	void put(Occupant newOccupant) throws CannotOccupyTileException, NotEnoughRoomException;

	boolean draw();

}
