package fiuba.algo3.map;

import fiuba.algo3.buildings.Occupant;

public class Gas extends Tile{

	public boolean canOccupy(Occupant newOccupant){
		return (!occupied && newOccupant.canOccupyGas());
	}

	public void occupy(Occupant newOccupant){
		if (canOccupy(newOccupant)){
			occupied = true;
			occupant = newOccupant;
		}
	}

}