package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;
import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.Barracks;

public class SpaceTest{

	@Test
	public void canBuildShouldReturnFalse(){
        Tile space = new Space();
        Building barrack = new Barracks();
        space.build(barrack);
        Assert.assertFalse(space.canBuild(barrack));
	}

}