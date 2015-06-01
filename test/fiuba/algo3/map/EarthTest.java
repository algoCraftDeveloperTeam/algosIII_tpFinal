package fiuba.algo3.map;

import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;

public class EarthTest{

	Player player = new Player();
	Buildable earth = new Earth();
	Buildable gas = new Gas();
	Buildable mineral = new Mineral();
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	@Test
	public void canBuildBarrackOnEarthShouldReturnTrue(){
        Assert.assertTrue(earth.canBuild(barrack));
	}

	/*@Test
	public void canBuildBarrackOcupiedShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}*/

	@Test
	public void canBuildBarrackOnGasShouldReturnFalse(){
        Assert.assertFalse(gas.canBuild(barrack));
	}

	@Test
	public void canBuildBarrackOnMineralShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(barrack));
	}

	@Test
	public void canBuildGasOnEarthShouldReturnFalse(){
        Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralOnEarthShouldReturnFalse(){
        Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void canBuildGasOnMineralShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(gasGetter));
	}

	@Test
	public void canBuildMineralOnGasShouldReturnFalse(){
        Assert.assertFalse(gas.canBuild(mineralGetter));
	}

}