package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.units.Unit;
import fiuba.algo3.units.Marine;

public class SpaceTest{

	Player player;
	Tile space;
	Building barrack;
	Unit marine;

	@Before
	public void setUp(){
		player = new Player();
		space = new Space();
		barrack = new Barracks(player);
		marine = new Marine();
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
	public void testCanStandNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(space.canStand());
	}

	@Test
	public void testCanLeaveNotOcupiedShouldReturnFalse(){
        Assert.assertFalse(space.canLeave());
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

	@Test
	public void testCanStandShouldReturnFalse(){
		space.stand(marine);
		Assert.assertFalse(space.canStand());
	}

	@Test
	public void testCanLeaveShouldReturnFalse(){
        space.leave();
        Assert.assertFalse(space.canLeave());
	}

}