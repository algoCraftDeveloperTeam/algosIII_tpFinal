package fiuba.algo3.map;

import fiuba.algo3.CannotOccupyTileException;
import fiuba.algo3.occupant.Occupant;
import org.junit.Assert;
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
		player = new Player();
		earth = new Earth();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
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

	@Test
	public void testEarthCanPutMineralGetter(){
		try {
			Assert.assertFalse(earth.put(mineralGetter));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEarthCanPutMarine(){
		try {
			Assert.assertTrue(earth.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEarthCanPutBarrack(){
		try {
			Assert.assertTrue(earth.put(barrack));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedEarthCanPutMarine(){
		try {
			earth.put(barrack);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertFalse(earth.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedEarthCanPutBarrack(){
		try {
			earth.put(marine);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		try {
			Assert.assertFalse(earth.put(barrack));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testOccupiedEarthWithMarineCanDraw(){
		try {
			earth.put(barrack);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(earth.draw());
	}

	@Test
	public void testOccupiedEarthWithBarrackCanDraw(){
		try {
			earth.put(marine);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(earth.draw());
	}

	@Test
	public void testVacatedEarthCanPutMarine(){
		try {
			earth.put(barrack);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		earth.draw();
		try {
			Assert.assertTrue(earth.put(marine));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testVacatedEarthCanPutBarrack(){
		try {
			earth.put(marine);
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
		earth.draw();
		try {
			Assert.assertTrue(earth.put(barrack));
		} catch (fiuba.algo3.CannotOccupyTileException e) {
			e.printStackTrace();
		}
	}

}