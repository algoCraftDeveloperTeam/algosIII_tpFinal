package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.Marine;

public class SpaceTest{

	Player player;
	Tile space;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player();
		space = new Space();
		marine = new Marine();
	}

//	tests
//		un marine puede ocupar espacio --> false

	@Test
	public void testSpaceCanPutMarine(){
		space.put(marine);
		Assert.assertFalse(space.canPut(marine));
	}

}