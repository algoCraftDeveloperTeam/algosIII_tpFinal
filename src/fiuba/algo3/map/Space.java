package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.units.Unit;

public class Space extends Tile{

	public boolean canBuild(Building b){
		return false;
	}

	public void build(Building b){

	}

	public boolean canStand(Unit u){
		return false;
	}

	public void stand(Unit u){

	}

}