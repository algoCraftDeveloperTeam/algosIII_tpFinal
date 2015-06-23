package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.player.Player;
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
		gas = new Gas();
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
		gas.put(gasGetter);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutMineralGetter() throws CannotOccupyTileException{
		gas.put(mineralGetter);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutMarine() throws CannotOccupyTileException{
		gas.put(marine);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testGasCanPutBarrack() throws CannotOccupyTileException{
		gas.put(barrack);
	}

	@Test (expected = CannotOccupyTileException.class)
	public void testOccupiedGasCanPutGasGetter() throws CannotOccupyTileException{
		gas.put(gasGetter);
		gas.put(gasGetter);
	}

	@Test
	public void testOccupiedGasWithGasGetterCanDraw() throws CannotOccupyTileException{
		gas.put(gasGetter);
		gas.draw();
	}

	@Test
	public void testVacatedGasCanPutGasGetter() throws CannotOccupyTileException{
		gas.put(gasGetter);
		gas.draw();
		gas.put(gasGetter);
	}

}