package fiuba.algo3.map;

import fiuba.algo3.units.Unit;

public interface Standable {

	boolean canStand(Unit u);

	void stand(Unit u);

	boolean canLeave();

	void leave();

}
