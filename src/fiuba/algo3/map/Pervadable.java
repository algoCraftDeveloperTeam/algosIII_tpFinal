package fiuba.algo3.map;

import fiuba.algo3.units.Unit;

public interface Pervadable {

	boolean canOccupy(Occupant newOccupant);

	void occupy(Occupant newOccupant);

	boolean canVacate();

	void vacate();

}
