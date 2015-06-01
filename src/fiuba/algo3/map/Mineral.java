package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Mineral extends Tile implements Buildable{

	private Building building;
	private BuildState state;

	public Mineral(){
		building = new NullBuilding();
		state = new StateNotOcupied();
	}

	public boolean canBuild(Building b){
		return (b.isMineralBuildable() && state.canBuild());
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
			state = new StateOcupied();
		}
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