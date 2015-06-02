package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.units.Unit;

public class Earth extends Tile{

	public boolean canBuild(Building b){
		return (b.isEarthBuildable() && occupantBuilding.canOccupy() && occupantUnit.canOccupy());
	}

	public void build(Building b){
		if (this.canBuild(b)){
			building = b;
			occupantBuilding = new StateOcupied();
		}
	}

	public boolean canStand(Unit u){
		return (occupantBuilding.canOccupy() && occupantUnit.canOccupy());
	}

	public void stand(Unit u){
		if (this.canStand(u)){
			unit = u;
			occupantUnit = new StateOcupied();
		}
	}

}