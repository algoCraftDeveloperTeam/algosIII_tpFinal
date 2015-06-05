package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;

public abstract class Tile implements Pervadable{

	protected Occupant occupant;

	protected boolean occupied;

	public Tile(){
		occupied = false;
	}

	public boolean canDraw(){
		return occupied;
	}

	public void draw(){
		if (canDraw()){
			occupied = false;
		}
	}

}