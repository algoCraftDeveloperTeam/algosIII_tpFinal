package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class SpaceTest{

	Player player;
	Buildable space;
	Building barrack;

	@Before
	public void setUp(){
		player = new Player();
		space = new Space();
		barrack = new Barracks(player);
	}

	@Test
	public void testCanBuildNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(space.canBuild(barrack));
	}

	@Test
	public void testCanDestroyNotOcupiedShouldReturnFalse(){
        Assert.assertFalse(space.canDestroy());
	}

	@Test
	public void testCanBuildShouldReturnFalse(){
		space.build(barrack);
        Assert.assertFalse(space.canBuild(barrack));
	}

	@Test
	public void testCanDestroyShouldReturnFalse(){
        space.destroy();
        Assert.assertFalse(space.canDestroy());
	}

}