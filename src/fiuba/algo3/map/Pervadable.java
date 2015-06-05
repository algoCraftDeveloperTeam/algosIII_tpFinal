package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;

public interface Pervadable {

	boolean canPut(Occupant newOccupant);

	void put(Occupant newOccupant);

	boolean canDraw();

	void draw();

}
