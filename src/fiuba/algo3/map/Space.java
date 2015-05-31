package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public class Space extends Tile implements Buildable{

	public Space(){
		
	}

	public boolean canBuild(Building b){
		return false;
	}

	public void build(Building b){
		
	}

}