package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public class StateOcupied implements BuildState{

	public boolean canBuild(){
		return false;
	}

	public boolean canDestroy(){
		return true;
	}

}