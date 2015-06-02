package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class GasTest{

	Player player;
	Buildable gas;
	Building barrack;
	Building mineralGetter;
	Building gasGetter;

	@Before
	public void setUp(){
		player = new Player();
		gas = new Gas();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
	}
	
	@Test
	public void testCanBuildBarrackShouldReturnFalse(){
		Assert.assertFalse(gas.canBuild(barrack));
	}

	@Test
	public void testCanBuildMineralGetterShouldReturnFalse(){
		Assert.assertFalse(gas.canBuild(mineralGetter));
	}

	@Test
	public void testCanBuildGasGetterShouldReturnTrue(){
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

	@Test
	public void testCanBuildOcupiedShouldReturnFalse(){
		gas.build(gasGetter);
		Assert.assertFalse(gas.canBuild(gasGetter));
	}

	@Test
	public void testCanDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(gas.canDestroy());
	}

	@Test
	public void testCanDestroyOcupiedShouldReturnTrue(){
		gas.build(gasGetter);
		Assert.assertTrue(gas.canDestroy());
	}

	@Test
	public void testCanBuildOnDestroyShouldReturnTrue(){
		gas.build(gasGetter);
		gas.destroy();
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

}