package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Earth extends Tile implements Buildable{

	private Building building;
	private BuildState state;

	public Earth(){
		state = new StateNotOcupied();
	}

	public boolean canBuild(Building b){
		return state.canBuild(b);
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
			state = new StateOcupied();
		}
	}

}