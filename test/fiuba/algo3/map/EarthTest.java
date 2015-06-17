package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.occupant.Occupant;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;

public class EarthTest{

	Player player;
	Tile earth;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player(new AlgoCraftMap(20));
		earth = new Earth();
		barrack = new Barracks(player, 0, 0);
		mineralGetter = new MineralCenter(player, 1, 1);
		gasGetter = new Asimilator(player, 1, 1);
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

}