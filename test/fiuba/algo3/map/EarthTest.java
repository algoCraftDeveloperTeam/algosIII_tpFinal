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
	public void canBuildGasGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void canBuildBarrackShouldReturnTrue(){
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(earth.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		earth.build(barrack);
		Assert.assertTrue(earth.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		earth.build(barrack);
		earth.destroy();
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildNothingShouldReturnFalse(){
		Building nullBuilding = new NullBuilding();
		Assert.assertFalse(earth.canBuild(nullBuilding));
	}

}