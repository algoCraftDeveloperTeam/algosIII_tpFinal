package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;

public class Mineral extends Tile{

	public boolean put(Occupant newOccupant){
		boolean response = false;
		if (!occupied && newOccupant.canOccupyMineral()){
			occupied = true;
			occupant = newOccupant;
			response = true;
		}
		return response;
	}

}