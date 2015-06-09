package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.occupant.units.Marine;

public class SpaceTest{

	Tile space;
	Occupant marine;

	@Before
	public void setUp(){
		space = new Space();
		marine = new Marine();
	}

//	tests
//		un marine puede ocupar espacio --> false

	@Test
	public void testSpaceCanPutMarine(){
		try {
			Assert.assertFalse(space.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

}