package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.NotEnoughRoomException;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.TerranTransportVessel;
import fiuba.algo3.model.occupant.units.Unit;

public class Earth extends Tile{


	public Earth(Coordinates coordinates){
		super(coordinates);
		info = "Earth. . ";
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException, NotEnoughRoomException {
		if(occupied && occupant.canTransport()){
			TerranTransportVessel occAsTransport = (TerranTransportVessel) occupant;
			occAsTransport.addUnit((Unit) newOccupant);
		}
		else if (!occupied && newOccupant.canOccupyEarth()){
			occupied = true;
			occupant = newOccupant;
		} else {
			throw new CannotOccupyTileException();
		}
	}

}