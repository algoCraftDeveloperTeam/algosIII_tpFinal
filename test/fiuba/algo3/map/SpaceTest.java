package fiuba.algo3.map;

import fiuba.algo3.player.Player;
import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class SpaceTest{

	Player player = new Player();
	Buildable space;
	Building barrack = new Barracks(player);

	@Test
	public void canBuildNotOcupiedShouldReturnFalse(){
		space = new Space();
        Assert.assertFalse(space.canBuild(barrack));
	}

	@Test
	public void canDestroyNotOcupiedShouldReturnFalse(){
        space = new Space();
        Assert.assertFalse(space.canDestroy());
	}

	@Test
	public void canBuildShouldReturnFalse(){
		space = new Space();
		space.build(barrack);
        Assert.assertFalse(space.canBuild(barrack));
	}

	@Test
	public void canDestroyShouldReturnFalse(){
        space = new Space();
        space.destroy();
        Assert.assertFalse(space.canDestroy());
	}

}