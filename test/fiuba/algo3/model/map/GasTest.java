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

public class GasTest{

	Player player;
	Tile gas;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player((new AlgoCraftMap(1)).testMap());
		gas = new Gas(new Coordinates(0,0));
		barrack = new Barracks(player, new Coordinates(0, 0));
		mineralGetter = new MineralCenter(player, new Coordinates(1, 1));
		gasGetter = new Asimilator(player, new Coordinates(2, 2));
		marine = new Marine();
	}
	
//	tests
//		un gasgetter puede ocupar gas --> true
//		un mineralgetter puede ocupar gas --> false
//		una unidad puede ocupar gas --> false
//		una barraca puede ocupar gas --> false
//		un gasgetter puede ocupar gas ya ocupada --> false
//		un gasgetter puede desocupar gas --> true
//		un gasgetter puede ocupar gas previamente ocupada --> true

	@Test
	public void testGasCanPutGasGetter() throws CannotOccupyTileException{
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutMineralGetter() throws CannotOccupyTileException{
		try {
			gas.put(mineralGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutMarine() throws CannotOccupyTileException{
		try {
			gas.put(marine);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutBarrack() throws CannotOccupyTileException{
		try {
			gas.put(barrack);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedGasCanPutGasGetter() throws CannotOccupyTileException{
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedGasWithGasGetterCanDraw() throws CannotOccupyTileException{
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		gas.draw();
	}

	@Test
	public void testVacatedGasCanPutGasGetter() throws CannotOccupyTileException{
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
		gas.draw();
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.model.exceptions.NotEnoughRoomException e) {
			e.printStackTrace();
		}
	}

}