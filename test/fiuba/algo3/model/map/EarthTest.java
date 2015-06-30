package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.buildings.Asimilator;
import fiuba.algo3.model.occupant.buildings.Barracks;
import fiuba.algo3.model.occupant.buildings.MineralCenter;
import fiuba.algo3.model.occupant.units.Marine;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EarthTest{

	Player player;
	Tile earth;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player((new AlgoCraftMap(1)).testMap());
		earth = new Earth(new Coordinates(0,0));
		barrack = new Barracks(player, new Coordinates(0, 0));
		mineralGetter = new MineralCenter(player, new Coordinates(1, 1));
		gasGetter = new Asimilator(player, new Coordinates(2, 2));
		marine = new Marine();
	}

//	tests
//		un gasgetter puede ocupar tierra --> false
//		un mineralgetter puede ocupar tierra --> false
//		una unidad puede ocupar tierra --> true
//		una barraca puede ocupar tierra --> true
//		una unidad puede ocupar tierra ya ocupada --> false
//		una barraca puede ocupar tierra ya ocupada --> false
//		una unidad puede desocupar tierra --> true
//		una barraca puede desocupar tierra --> true
//		una unidad puede ocupar tierra previamente ocupada --> true
//		una barraca puede ocupar tierra previamente ocupada --> true

	@Test (expected = CannotOccupyTileException.class)
	public void testEarthCanPutGasGetter() throws CannotOccupyTileException{
		earth.put(gasGetter);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testEarthCanPutMineralGetter() throws CannotOccupyTileException{
		earth.put(mineralGetter);
	}

	@Test
	public void testEarthCanPutMarine() throws CannotOccupyTileException{
		earth.put(marine);
	}

	@Test
	public void testEarthCanPutBarrack() throws CannotOccupyTileException{
		earth.put(barrack);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedEarthCanPutMarine() throws CannotOccupyTileException{
		earth.put(barrack);
		earth.put(marine);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedEarthCanPutBarrack() throws CannotOccupyTileException{
		earth.put(marine);
		earth.put(barrack);
	}

	@Test
	public void testOccupiedEarthWithMarineCanDraw() throws CannotOccupyTileException{
		earth.put(barrack);
		earth.draw();
	}

	@Test
	public void testOccupiedEarthWithBarrackCanDraw() throws CannotOccupyTileException{
		earth.put(marine);
		earth.draw();
	}

	@Test
	public void testVacatedEarthCanPutMarine() throws CannotOccupyTileException{
		earth.put(barrack);
		earth.draw();
		earth.put(marine);
	}

	@Test
	public void testVacatedEarthCanPutBarrack() throws CannotOccupyTileException{
		earth.put(marine);
		earth.draw();
		earth.put(barrack);
	}

	@Test (expected = EmptyTileException.class)
	public void testGetOccupantEmpty() throws EmptyTileException{
		marine = earth.getOccupant();
	}

	@Test
	public void testGetPosition() throws Exception {
		Coordinates expectedPosition = new Coordinates(0, 0);
		Assert.assertEquals(expectedPosition, earth.getPosition());

	}
}