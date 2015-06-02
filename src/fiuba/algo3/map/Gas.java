package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public class Gas extends Tile implements Buildable{

	public boolean canBuild(Building b){
		return (b.isGasBuildable() && state.canBuild());
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
			state = new StateOcupied();
		}
	}

}