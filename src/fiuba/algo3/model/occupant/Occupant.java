package fiuba.algo3.model.occupant;

import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

public interface Occupant {

	boolean canOccupyEarth();

	boolean canOccupyGas();

	boolean canOccupyMineral();

    boolean canMove();

    boolean canAttack();

    boolean canCreate();

	Coordinates getPosition();

	Player getOwner();

	String getInfo();

	boolean canTransport();

}