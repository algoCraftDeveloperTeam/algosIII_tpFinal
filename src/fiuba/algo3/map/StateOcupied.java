package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public class StateOcupied implements BuildState{

	public boolean canBuild(Building b){
		return false;
	}

}