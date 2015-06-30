package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.occupant.Occupant;

public class Gas extends Tile{


	public Gas(Coordinates coordinates){
		super(coordinates);
		info = "Gas: refinalo (?).";
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