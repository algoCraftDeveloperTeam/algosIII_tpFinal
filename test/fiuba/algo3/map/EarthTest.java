package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;

public class EarthTest{

	@Test
	public void canBuildOnInitShouldReturnTrue(){
        Earth earth = new Earth();
        Assert.assertTrue(earth.canBuild());
	}

}