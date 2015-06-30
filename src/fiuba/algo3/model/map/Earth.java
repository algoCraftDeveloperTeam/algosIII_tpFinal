package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.occupant.Occupant;

public class Earth extends Tile{


	public Earth(Coordinates coordinates){
		super(coordinates);
		info = "Earth";
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