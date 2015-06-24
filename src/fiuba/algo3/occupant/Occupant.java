package fiuba.algo3.occupant;

import fiuba.algo3.map.Coordinates;

public interface Occupant {

	boolean canOccupyEarth();

	boolean canOccupyGas();

	boolean canOccupyMineral();

	boolean canBuild();

    boolean canMove();

    boolean canAttack();
	Coordinates getPosition();

}