package fiuba.algo3.map;

import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class EarthTest{

	@Test
	public void canBuildShouldReturnTrue(){
        Tile earth = new Earth();
		Player owner = new Player();
        Building barrack = new Barracks(owner);
        Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildShouldReturnFalse(){
		Tile earth = new Earth();
		Player owner = new Player();
		Building barrack = new Barracks(owner);
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

}