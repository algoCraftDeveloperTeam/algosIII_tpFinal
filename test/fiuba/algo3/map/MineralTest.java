package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class MineralTest{

	Player player = new Player();
	Buildable mineral;
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	
	@Test
	public void canBuildBarrackShouldReturnFalse(){
		mineral = new Mineral();
		Assert.assertFalse(mineral.canBuild(barrack));
	}

	@Test
	public void canBuildGasGetterShouldReturnFalse(){
		mineral = new Mineral();
		Assert.assertFalse(mineral.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralGetterShouldReturnTrue(){
		mineral = new Mineral();
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		mineral = new Mineral();
		mineral.build(mineralGetter);
		Assert.assertFalse(mineral.canBuild(mineralGetter));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		mineral = new Mineral();
		Assert.assertFalse(mineral.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		mineral = new Mineral();
		mineral.build(mineralGetter);
		Assert.assertTrue(mineral.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		mineral = new Mineral();
		mineral.build(mineralGetter);
		mineral.destroy();
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

}