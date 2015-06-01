package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class GasTest{

	Player player = new Player();
	Buildable gas;
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	
	@Test
	public void canBuildBarrackShouldReturnFalse(){
		gas = new Gas();
		Assert.assertFalse(gas.canBuild(barrack));
	}

	@Test
	public void canBuildMineralGetterShouldReturnFalse(){
		gas = new Gas();
        Assert.assertFalse(gas.canBuild(mineralGetter));
	}

	@Test
	public void canBuildGasGetterShouldReturnTrue(){
		gas = new Gas();
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

	@Test
	public void canBuildOcupiedShouldReturnFalse(){
		gas = new Gas();
		gas.build(gasGetter);
		Assert.assertFalse(gas.canBuild(gasGetter));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
		gas = new Gas();
		Assert.assertFalse(gas.canDestroy());
	}

	@Test
	public void canDestroyOcupiedShouldReturnTrue(){
		gas = new Gas();
		gas.build(gasGetter);
		Assert.assertTrue(gas.canDestroy());
	}

	@Test
	public void canBuildOnDestroyShouldReturnTrue(){
		gas = new Gas();
		gas.build(gasGetter);
		gas.destroy();
		Assert.assertTrue(gas.canBuild(gasGetter));
	}

}