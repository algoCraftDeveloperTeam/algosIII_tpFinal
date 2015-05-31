package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Earth extends Tile implements Buildable{

	private Building building;

	public Earth(){
		building = new NullBuilding();
	}

	public boolean canBuild(Building b){
		if (building.isNil()){
			return true;
		} else{
			return false;
		}
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
		}
	}

}