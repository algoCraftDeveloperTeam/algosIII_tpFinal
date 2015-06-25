package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;

public class Earth extends Tile{

	public Earth(Coordinates coordinates){
		super(coordinates);
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException {
		if (!occupied && newOccupant.canOccupyEarth()){
			occupied = true;
			occupant = newOccupant;
		} else {
			throw new CannotOccupyTileException();
		}
	}

}