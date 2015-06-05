package fiuba.algo3.map;

public class Gas extends Tile{

	public boolean canPut(Occupant newOccupant){
		return (!occupied && newOccupant.canOccupyGas());
	}

	public void put(Occupant newOccupant){
		if (canPut(newOccupant)){
			occupied = true;
			occupant = newOccupant;
		}
	}

}