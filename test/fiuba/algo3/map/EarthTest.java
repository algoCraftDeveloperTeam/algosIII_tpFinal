package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import fiuba.algo3.player.Player;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;
import fiuba.algo3.buildings.Asimilator;
import fiuba.algo3.buildings.MineralCenter;
import fiuba.algo3.buildings.NullBuilding;
import fiuba.algo3.units.Unit;
import fiuba.algo3.units.Marine;

public class EarthTest{

	Player player;
	Tile earth;
	Building barrack;
	Building mineralGetter;
	Building gasGetter;
	Unit marine;

	@Before
	public void setUp(){
		player = new Player();
		earth = new Earth();
		barrack = new Barracks(player);
		mineralGetter = new MineralCenter(player);
		gasGetter = new Asimilator(player);
		marine = new Marine();
	}

	@Test
	public void testCanBuildGasGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(gasGetter));
	}

	@Test
	public void testCanBuildMineralGetterShouldReturnFalse(){
		Assert.assertFalse(earth.canBuild(mineralGetter));
	}

	@Test
	public void testCanBuildBarrackShouldReturnTrue(){
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void testCanBuildOcupiedWithBuildingShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

	@Test
	public void testCanBuildOcupiedWithUnitShouldReturnFalse(){
		earth.stand(marine);
		Assert.assertFalse(earth.canBuild(barrack));
	}

	@Test
	public void testCanDestroyNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(earth.canDestroy());
	}

	@Test
	public void testCanDestroyOcupiedShouldReturnTrue(){
		earth.build(barrack);
		Assert.assertTrue(earth.canDestroy());
	}

	@Test
	public void testCanBuildOnDestroyShouldReturnTrue(){
		earth.build(barrack);
		earth.destroy();
		Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void testCanBuildNothingShouldReturnFalse(){
		Building nullBuilding = new NullBuilding();
		Assert.assertFalse(earth.canBuild(nullBuilding));
	}

	@Test
	public void testCanStandUnitShouldReturnTrue(){
		Assert.assertTrue(earth.canStand(marine));
	}

	@Test
	public void testCanStandUnitWithBuildingShouldReturnFalse(){
		earth.build(barrack);
		Assert.assertFalse(earth.canStand(marine));
	}

	@Test
	public void testCanStandUnitWithUnitShouldReturnFalse(){
		earth.stand(marine);
		Assert.assertFalse(earth.canStand(marine));
	}

	@Test
	public void testCanLeaveNotOcupiedShouldReturnFalse(){
		Assert.assertFalse(earth.canLeave());
	}

	@Test
	public void testCanLeaveOcupiedShouldReturnTrue(){
		earth.stand(marine);
		Assert.assertTrue(earth.canLeave());
	}

	@Test
	public void testCanStandOnLeaveShouldReturnTrue(){
		earth.stand(marine);
		earth.leave();
		Assert.assertTrue(earth.canStand(marine));
	}

}