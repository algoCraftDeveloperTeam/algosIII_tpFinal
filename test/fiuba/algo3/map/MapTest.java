package fiuba.algo3.map;

import junit.framework.Assert;
import org.junit.Test;

public class MapTest{

	@Test
	public void isEmptyShouldReturnTrue(){
        Map map = new Map();
        Assert.assertTrue(map.isEmpty());
	}

}