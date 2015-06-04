package fiuba.algo3.gameVariables;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 04/06/15.
 */
public class PositionTest {

    private Position aPosition;
    @Before
    public void setUp() throws Exception {
        aPosition = new Position(1, 5);
    }

    @Test
    public void testGetX() throws Exception {
        Assert.assertEquals(1, aPosition.getX());
    }

    @Test
    public void testGetY() throws Exception {
        Assert.assertEquals(5, aPosition.getY());
    }

    @Test
    public void testMoveInXAxis() throws Exception {
        aPosition.move(2, 5);

        Assert.assertEquals(2, aPosition.getX());
    }

    @Test
    public void testMoveInYAxis() throws Exception {
        aPosition.move(1, 6);

        Assert.assertEquals(6, aPosition.getY());
    }
}