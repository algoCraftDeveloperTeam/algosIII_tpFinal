package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;

public class EarthTest{

	@Test
	public void canBuildShouldReturnTrue(){
        Tile earth = new Earth();
        Assert.assertTrue(earth.canBuild(1));
	}

}