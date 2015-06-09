package fiuba.algo3.map;

import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.occupant.Occupant;

public abstract class Tile implements Pervadable{

	protected Occupant occupant;

	protected boolean occupied;

	public Tile(){
		occupied = false;
	}

	public boolean draw(){
		boolean response = occupied;
		occupied = false;
		return response;
	}

	public void clear() {
		this.occupied = false;
	}

	public Occupant getOccupant() throws EmptyTileException{
		if (!this.isOccupied()){
			throw new EmptyTileException();
		}
		return this.occupant;
	}

	public boolean isOccupied(){
		return this.occupied;
	}
}