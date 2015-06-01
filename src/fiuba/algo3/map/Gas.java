package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Gas extends Tile implements Buildable{

	private Building building;

	public Gas(){
		building = new NullBuilding();
	}

	public boolean canBuild(Building b){
		return b.isGasBuildable();
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
		}
	}

}