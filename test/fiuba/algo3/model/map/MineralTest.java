package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.buildings.Asimilator;
import fiuba.algo3.model.occupant.buildings.Barracks;
import fiuba.algo3.model.occupant.buildings.MineralCenter;
import fiuba.algo3.model.occupant.units.Marine;
import fiuba.algo3.model.player.Player;
import org.junit.Before;
import org.junit.Test;

public class MineralTest{

	Player player;
	Tile mineral;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player((new AlgoCraftMap(1)).testMap());
		mineral = new Mineral(new Coordinates(0,0));
		barrack = new Barracks(player, new Coordinates(0, 0));
		mineralGetter = new MineralCenter(player, new Coordinates(1, 1));
		gasGetter = new Asimilator(player, new Coordinates(2, 2));
		marine = new Marine();
	}

//	tests
//		un gasgetter puede ocupar mineral --> false
//		un mineralgetter puede ocupar mineral --> true
//		una unidad puede ocupar mineral --> false
//		una barraca puede ocupar mineral --> false
//		un mineralGetter puede ocupar mineral ya ocupada --> false
//		un mineralGetter puede desocupar mineral --> true
//		un mineralGetter puede ocupar mineral previamente ocupada --> true

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutGasGetter() throws CannotOccupyTileException{
		try {
			mineral.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMineralCanPutMineralGetter() throws CannotOccupyTileException{
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutMarine() throws CannotOccupyTileException{
		try {
			mineral.put(marine);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testMineralCanPutBarrack() throws CannotOccupyTileException{
		try {
			mineral.put(barrack);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedMineralCanPutMineralGetter() throws CannotOccupyTileException{
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedMineralWithMineralGetterCanDraw() throws CannotOccupyTileException{
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		mineral.draw();
	}

	@Test
	public void testVacatedMineralCanPutMineralGetter() throws CannotOccupyTileException{
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		mineral.draw();
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

}