package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class EarthTest{

	@Test
	public void canBuildShouldReturnTrue(){
        Buildable earth = new Earth();
        Building barrack = new Barracks();
        Assert.assertTrue(earth.canBuild(barrack));
	}

	@Test
	public void canBuildShouldReturnFalse(){
		Buildable earth = new Earth();
		Building barrack = new Barracks();
		earth.build(barrack);
		Assert.assertFalse(earth.canBuild(barrack));
	}

}