package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;
import fiuba.algo3.units.Unit;
import fiuba.algo3.units.NullUnit;

public abstract class Tile implements Buildable, Standable{

	protected Building building;

	protected Unit unit;

	public Tile(){
		building = new NullBuilding();
		unit = new NullUnit();
	}

	public boolean canDestroy(){
		return building.canQuit();
	}

	public void destroy(){
		if (this.canDestroy()){
			building = new NullBuilding();
		}
	}

	public boolean canLeave(){
		return unit.canQuit();
	}

	public void leave(){
		if (this.canLeave()){
			unit = new NullUnit();
		}
	}

}