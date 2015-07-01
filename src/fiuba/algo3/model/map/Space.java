package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.NotEnoughRoomException;
import fiuba.algo3.model.occupant.Occupant;

public class Space extends Tile{


	public Space(Coordinates coordinates){
		super(coordinates);
		info = "Space";
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException, NotEnoughRoomException {
		throw new CannotOccupyTileException();
	}

}