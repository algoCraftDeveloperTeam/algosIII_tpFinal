package fiuba.algo3.map;

import fiuba.algo3.occupant.Occupant;
import junit.framework.Assert;
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
		Assert.assertFalse(mineral.put(gasGetter));
	}

	@Test
	public void testMineralCanPutMineralGetter(){
		Assert.assertTrue(mineral.put(mineralGetter));
	}

	@Test
	public void testMineralCanPutMarine(){
		Assert.assertFalse(mineral.put(marine));
	}

	@Test
	public void testMineralCanPutBarrack(){
		Assert.assertFalse(mineral.put(barrack));
	}

	@Test
	public void testOccupiedMineralCanPutMineralGetter(){
		mineral.put(mineralGetter);
		Assert.assertFalse(mineral.put(mineralGetter));
	}

	@Test
	public void testOccupiedMineralWithMineralGetterCanDraw(){
		mineral.put(mineralGetter);
		Assert.assertTrue(mineral.draw());
	}

	@Test
	public void testVacatedMineralCanPutMineralGetter(){
		mineral.put(mineralGetter);
		mineral.draw();
		Assert.assertTrue(mineral.put(mineralGetter));
	}

}