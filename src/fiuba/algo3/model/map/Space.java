package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.occupant.Occupant;

public class Space extends Tile{


	public Space(Coordinates coordinates){
		super(coordinates);
		info = "Tierra: en estos paramos se pueden construir todo tipo de edificios,\nexceptuando los de recoleccion de recursos, \ntodas las unidades pueden caminar sobre ellos.";
	}

	public void put(Occupant newOccupant) throws CannotOccupyTileException {
		throw new CannotOccupyTileException();
	}

}