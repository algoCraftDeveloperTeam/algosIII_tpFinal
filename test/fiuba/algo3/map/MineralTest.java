package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;
import fiuba.algo3.units.Unit;
import fiuba.algo3.units.Marine;

public class MineralTest{

	Player player;
	Tile mineral;
	Building barrack;
	Building mineralGetter;
	Building gasGetter;
	Unit marine;

	@Before
	public void setUp(){
		player = new Player();
		mineral = new Mineral();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
		marine = new Marine();
	}

	@Test
	public void testCanBuildBarrackShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(barrack));
	}

	@Test
	public void testCanBuildGasGetterShouldReturnFalse(){
		Assert.assertFalse(mineral.canBuild(gasGetter));
	}

	@Test
	public void testCanBuildMineralGetterShouldReturnTrue(){
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

	@Test
	public void testCanBuildOcupieWithBuildingdShouldReturnFalse(){
		mineral.build(mineralGetter);
		Assert.assertFalse(mineral.canBuild(mineralGetter));
	}

	@Test
	public void testCanDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(mineral.canDestroy());
	}

	@Test
	public void testCanDestroyOcupiedShouldReturnTrue(){
		mineral.build(mineralGetter);
		Assert.assertTrue(mineral.canDestroy());
	}

	@Test
	public void testCanBuildOnDestroyShouldReturnTrue(){
		mineral.build(mineralGetter);
		mineral.destroy();
		Assert.assertTrue(mineral.canBuild(mineralGetter));
	}

	@Test
	public void testCanStandNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(mineral.canStand());
	}

	@Test
	public void testCanLeaveNotOcupiedShouldReturnFalse(){
        Assert.assertFalse(mineral.canLeave());
	}

	@Test
	public void testCanStandShouldReturnFalse(){
		mineral.stand(marine);
		Assert.assertFalse(mineral.canStand());
	}

	@Test
	public void testCanLeaveShouldReturnFalse(){
        mineral.leave();
        Assert.assertFalse(mineral.canLeave());
	}

}