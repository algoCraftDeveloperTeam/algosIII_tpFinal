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
	Buildable mineral = new Mineral();
	Building barrack = new Barracks(player);
	Building mineralGetter = new MineralCenter(player);
	Building gasGetter = new Asimilator(player);

	
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

	/*@Test
	public void canBuildOcupiedShouldReturnFalse(){
		mineral.build(mineralGetter);
		Assert.assertFalse(mineral.canBuild(mineralGetter));
	}*/
}