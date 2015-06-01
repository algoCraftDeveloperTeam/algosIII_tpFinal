package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;

public class Space extends Tile implements Buildable{

	private Building building;

	public Space(){
		building = new NullBuilding();
	}

	public boolean canBuild(Building b){
		return false;
	}

	public void build(Building b){

	}

	public boolean canDestroy(){
		return false;
	}

	public void destroy(){
		
	}

}