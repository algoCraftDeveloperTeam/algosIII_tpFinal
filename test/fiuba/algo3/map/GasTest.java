package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;
import fiuba.algo3.units.Marine;

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
		Assert.assertTrue(gas.canPut(gasGetter));
	}

	@Test
	public void testGasCanPutMineralGetter(){
		Assert.assertFalse(gas.canPut(mineralGetter));
	}

	@Test
	public void testGasCanPutMarine(){
		Assert.assertFalse(gas.canPut(marine));
	}

	@Test
	public void testGasCanPutBarrack(){
		Assert.assertFalse(gas.canPut(barrack));
	}

	@Test
	public void testOccupiedGasCanPutGasGetter(){
		gas.put(gasGetter);
		Assert.assertFalse(gas.canPut(gasGetter));
	}

	@Test
	public void testOccupiedGasWithGasGetterCanDraw(){
		gas.put(gasGetter);
		Assert.assertTrue(gas.canDraw());
	}

	@Test
	public void testVacatedGasCanPutGasGetter(){
		gas.put(gasGetter);
		gas.draw();
		Assert.assertTrue(gas.canPut(gasGetter));
	}

}