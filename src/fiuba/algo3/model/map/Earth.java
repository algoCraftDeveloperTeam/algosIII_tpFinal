package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.occupant.Occupant;

public class Earth extends Tile{


	public Earth(Coordinates coordinates){
		super(coordinates);
		info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
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