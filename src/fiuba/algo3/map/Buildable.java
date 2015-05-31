package fiuba.algo3.map;

import fiuba.algo3.buildings.Building;

public interface Buildable {

	boolean canBuild(Building b);

	void build(Building b);

}
