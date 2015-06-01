package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class EarthTest{

	Player player = new Player();
	Buildable earth;
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	@Test
	public void canBuildGasGetterShouldReturnFalse(){
		earth = new Earth();
        Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralGetterShouldReturnFalse(){
		earth = new Earth();
        Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void canBuildBarrackShouldReturnTrue(){
		earth = new Earth();
        Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		earth = new Earth();
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		earth = new Earth();
		Assert.assertFalse(earth.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		earth = new Earth();
		earth.build(barrack);
		Assert.assertTrue(earth.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		earth = new Earth();
		earth.build(barrack);
		earth.destroy();
		Assert.assertTrue(earth.canBuild(barrack));
	}

}