package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Asimilator;
import fiuba.algo3.occupant.buildings.MineralCenter;
import fiuba.algo3.occupant.units.Marine;

public class GasTest{

	Player player;
	Tile gas;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player();
		gas = new Gas();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
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
	public void testGasCanPutGasGetter(){
		try {
			Assert.assertTrue(gas.put(gasGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGasCanPutMineralGetter(){
		try {
			Assert.assertFalse(gas.put(mineralGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGasCanPutMarine(){
		try {
			Assert.assertFalse(gas.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGasCanPutBarrack(){
		try {
			Assert.assertFalse(gas.put(barrack));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedGasCanPutGasGetter(){
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertFalse(gas.put(gasGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedGasWithGasGetterCanDraw(){
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(gas.draw());
	}

	@Test
	public void testVacatedGasCanPutGasGetter(){
		try {
			gas.put(gasGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		gas.draw();
		try {
			Assert.assertTrue(gas.put(gasGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

}