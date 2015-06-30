package fiuba.algo3.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mporto on 29/06/15.
 */
public class CannotOccupyTileExceptionTest {

    @Test
    public void testGetMessage() throws Exception {
        CannotOccupyTileException exception = new CannotOccupyTileException();
        Assert.assertEquals("The tile cannot be occupied.", exception.getMessage());
    }
}