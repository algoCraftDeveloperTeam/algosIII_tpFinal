package fiuba.algo3.occupant;

import fiuba.algo3.map.Coordinates;

public interface Occupant {

	boolean canOccupyEarth();

	boolean canOccupyGas();

	boolean canOccupyMineral();

	Coordinates getPosition();

}