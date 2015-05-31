package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;

public class SpaceTest{

	@Test
	public void canBuildShouldReturnFalse(){
        Tile space = new Space();
        Assert.assertFalse(space.canBuild(1));
	}

}