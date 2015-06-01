package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public class StateNotOcupied implements BuildState{

	public boolean canBuild(Building b){
		return b.isEarthBuildable();
	}

}