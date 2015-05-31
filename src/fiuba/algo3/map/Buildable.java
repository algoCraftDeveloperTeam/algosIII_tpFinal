package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public interface Buildable {

	abstract boolean canBuild(Building b);

	abstract void build(Building b);

}
