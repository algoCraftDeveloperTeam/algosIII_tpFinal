package fiuba.algo3.occupant;

import fiuba.algo3.map.Coordinates;
import fiuba.algo3.player.Player;

public interface Occupant {

	boolean canOccupyEarth();

	boolean canOccupyGas();

	boolean canOccupyMineral();

    boolean canMove();

    boolean canAttack();

    boolean canCreate();

	Coordinates getPosition();

	Player getOwner();

}