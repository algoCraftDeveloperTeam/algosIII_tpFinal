package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;

public class Mineral extends Tile{

	public boolean canPut(Occupant newOccupant){
		return (!occupied && newOccupant.canOccupyMineral());
	}

	public void put(Occupant newOccupant){
		if (canPut(newOccupant)){
			occupied = true;
			occupant = newOccupant;
		}
	}

}