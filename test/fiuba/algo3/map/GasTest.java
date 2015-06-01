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
	public void canBuildBarrackShouldReturnFalse(){
		Assert.assertFalse(gas.canBuild(barrack));
	}

	@Test
	public void canBuildMineralGetterShouldReturnFalse(){
		Assert.assertFalse(gas.canBuild(mineralGetter));
	}

	@Test
	public void canBuildGasGetterShouldReturnTrue(){
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		gas.build(gasGetter);
		Assert.assertFalse(gas.canBuild(gasGetter));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(gas.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		gas.build(gasGetter);
		Assert.assertTrue(gas.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		gas.build(gasGetter);
		gas.destroy();
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

}