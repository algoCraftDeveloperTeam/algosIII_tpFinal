package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.occupant.Occupant;

public abstract class Tile implements Pervadable{

	protected Occupant occupant;

	protected boolean occupied;

	protected Coordinates position;

	public Tile(Coordinates coordinates){
		occupied = false;
		position = coordinates;
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

	/*
	public void ocuparTurbio(){
		this.occupied = true;
	}
    */
	public Coordinates getPosition(){
		return position;
	}
}