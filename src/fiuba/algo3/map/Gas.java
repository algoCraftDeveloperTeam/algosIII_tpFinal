package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;

public class Gas extends Tile{

	public Gas(Coordinates coordinates){
		super(coordinates);
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException {
		if (!occupied && newOccupant.canOccupyGas()){
			occupied = true;
			occupant = newOccupant;
		} else {
			throw new CannotOccupyTileException();
		}
	}

}