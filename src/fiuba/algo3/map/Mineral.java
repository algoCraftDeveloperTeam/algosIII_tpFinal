package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Mineral extends Tile implements Buildable{

	private Building building;

	public Mineral(){
		building = new NullBuilding();
	}

	public boolean canBuild(Building b){
		return building.isMineralBuildable();
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
		}
	}

}