package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;

public class Mineral extends Tile{

	public Mineral(Coordinates coordinates){
		super(coordinates);
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException {
		if (!occupied && newOccupant.canOccupyMineral()){
			occupied = true;
			occupant = newOccupant;
		} else {
			throw new CannotOccupyTileException();
		}
	}

}