package fiuba.algo3.map;

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