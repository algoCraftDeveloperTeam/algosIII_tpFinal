package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public abstract class Tile{

	protected Building building;

	protected BuildState state;

	public Tile(){
		building = new NullBuilding();
		state = new StateNotOcupied();
	}

	public boolean canDestroy(){
		return state.canDestroy();
	}

	public void destroy(){
		if (this.canDestroy()){
			building = new NullBuilding();
			state = new StateNotOcupied();
		}
	}

}