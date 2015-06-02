package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;
import fiuba.algo3.buildings.NullBuilding;

public class EarthTest{

	Player player;
	Buildable earth;
	Building barrack;
	Building mineralGetter;
	Building gasGetter;

	@Before
	public void setUp(){
		player = new Player();
		earth = new Earth();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
	}

	@Test
	public void testCanBuildGasGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void testCanBuildMineralGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void testCanBuildBarrackShouldReturnTrue(){
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void testCanBuildOcupiedShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

	@Test
	public void testCanDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(earth.canDestroy());
	}

	@Test
	public void testCanDestroyOcupiedShouldReturnTrue(){
		earth.build(barrack);
		Assert.assertTrue(earth.canDestroy());
	}

	@Test
	public void testCanBuildOnDestroyShouldReturnTrue(){
		earth.build(barrack);
		earth.destroy();
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void testCanBuildNothingShouldReturnFalse(){
		Building nullBuilding = new NullBuilding();
		Assert.assertFalse(earth.canBuild(nullBuilding));
	}

}