package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;

public class Earth extends Tile{

	public boolean canPut(Occupant newOccupant){
		return (!occupied && newOccupant.canOccupyEarth());
	}

	public void put(Occupant newOccupant){
		if (canPut(newOccupant)){
			occupied = true;
			occupant = newOccupant;
		}
	}

}