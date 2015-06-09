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

public class MineralTest{

	Player player;
	Tile mineral;
	Occupant barrack;
	Occupant mineralGetter;
	Occupant gasGetter;
	Occupant marine;

	@Before
	public void setUp(){
		player = new Player();
		mineral = new Mineral();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
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

	@Test
	public void testMineralCanPutGasGetter(){
		try {
			Assert.assertFalse(mineral.put(gasGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMineralCanPutMineralGetter(){
		try {
			Assert.assertTrue(mineral.put(mineralGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMineralCanPutMarine(){
		try {
			Assert.assertFalse(mineral.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMineralCanPutBarrack(){
		try {
			Assert.assertFalse(mineral.put(barrack));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedMineralCanPutMineralGetter(){
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertFalse(mineral.put(mineralGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedMineralWithMineralGetterCanDraw(){
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(mineral.draw());
	}

	@Test
	public void testVacatedMineralCanPutMineralGetter(){
		try {
			mineral.put(mineralGetter);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		mineral.draw();
		try {
			Assert.assertTrue(mineral.put(mineralGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

}