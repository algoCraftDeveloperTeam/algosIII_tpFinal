package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.exceptions.CannotOccupyTileException;

public class SpaceTest{

	Tile space;
	Occupant marine;

	@Before
	public void setUp(){
		space = new Space(new Coordinates(0,0));
		marine = new Marine();
	}

//	tests
//		un marine puede ocupar espacio --> false

	@Test (expected = CannotOccupyTileException.class)
	public void testSpaceCanPutMarine() throws CannotOccupyTileException{
		space.put(marine);
	}

}