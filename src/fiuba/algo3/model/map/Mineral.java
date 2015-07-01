package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.NotEnoughRoomException;
import fiuba.algo3.model.occupant.Occupant;

public class Mineral extends Tile{


	public Mineral(Coordinates coordinates){
		super(coordinates);
		info = "Mineral";
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException, NotEnoughRoomException {
		if (!occupied && newOccupant.canOccupyMineral()){
			occupied = true;
			occupant = newOccupant;
		} else {
			throw new CannotOccupyTileException();
		}
	}

}