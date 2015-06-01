package fiuba.algo3.map;

import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class SpaceTest{

	@Test
	public void canBuildShouldReturnFalse(){
        Tile space = new Space();
        Player owner = new Player();
        Building barrack = new Barracks(owner);
        space.build(barrack);
        Assert.assertFalse(space.canBuild(barrack));
	}

}