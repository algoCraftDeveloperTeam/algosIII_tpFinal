package fiuba.algo3.map;

import fiuba.algo3.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;

public interface Pervadable {

	void put(Occupant newOccupant) throws CannotOccupyTileException;

	boolean draw();

}
