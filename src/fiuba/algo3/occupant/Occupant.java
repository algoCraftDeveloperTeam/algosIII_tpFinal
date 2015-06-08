package fiuba.algo3.occupant;

import fiuba.algo3.gameVariables.Position;

public interface Occupant {

	boolean canOccupyEarth();

	boolean canOccupyGas();

	boolean canOccupyMineral();

	Position getPosition();

}