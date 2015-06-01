package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class MineralTest{

	Player player;
	Buildable mineral;
	Building barrack;
	Building mineralGetter;
	Building gasGetter;

	@Before
	public void setUp(){
		player = new Player();
		mineral = new Mineral();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
	}

	@Test
	public void canBuildBarrackShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(barrack));
	}

	@Test
	public void canBuildGasGetterShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralGetterShouldReturnTrue(){
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		mineral.build(mineralGetter);
		Assert.assertFalse(mineral.canBuild(mineralGetter));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(mineral.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		mineral.build(mineralGetter);
		Assert.assertTrue(mineral.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		mineral.build(mineralGetter);
		mineral.destroy();
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

}