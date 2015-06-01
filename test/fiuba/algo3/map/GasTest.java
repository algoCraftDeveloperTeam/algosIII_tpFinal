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
	Buildable gas = new Gas();
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	
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

	/*@Test
	public void canBuildOcupiedShouldReturnFalse(){
		gas.build(gasGetter);
		Assert.assertFalse(gas.canBuild(gasGetter));
	}*/

}