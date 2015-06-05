package fiuba.algo3.map;

import fiuba.algo3.buildings.Occupant;

public abstract class Tile implements Pervadable{

	protected Occupant occupant;

	protected boolean occupied;

	public Tile(){
		occupied = false;
	}

	public boolean canVacate(){
		return occupied;
	}

	public boolean vacate(){
		if (canVacate()){
			occupied = false;
		}
	}

}