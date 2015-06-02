package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.NullBuilding;
import fiuba.algo3.units.Unit;
import fiuba.algo3.units.NullUnit;

public abstract class Tile implements Buildable, Standable{

	protected Building building;

	protected Unit unit;

	protected OccupantState occupantBuilding;

	protected OccupantState occupantUnit;

	public Tile(){
		building = new NullBuilding();
		unit = new NullUnit();
		occupantBuilding = new StateNotOcupied();
		occupantUnit = new StateNotOcupied();
	}

	public boolean canDestroy(){
		return occupantBuilding.canQuit();
	}

	public void destroy(){
		if (this.canDestroy()){
			building = new NullBuilding();
			occupantBuilding = new StateNotOcupied();
		}
	}

	public boolean canLeave(){
		return occupantUnit.canQuit();
	}

	public void leave(){
		if (this.canLeave()){
			unit = new NullUnit();
			occupantUnit = new StateNotOcupied();
		}
	}

}