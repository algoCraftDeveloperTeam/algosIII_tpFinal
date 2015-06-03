package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.units.Unit;

public class Gas extends Tile{

	public boolean canBuild(Building b){
		return (b.isGasBuildable() && occupantBuilding.canOccupy() && occupantUnit.canOccupy());
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
			occupantBuilding = new StateOcupied();
		}
	}

	public boolean canStand(Unit u){
		return false;
	}

	public void stand(Unit u){

	}

}