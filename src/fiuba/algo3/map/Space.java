package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;

public class Space extends Tile{

	public Space(Coordinates coordinates){
		super(coordinates);
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException {
		throw new CannotOccupyTileException();
	}

}