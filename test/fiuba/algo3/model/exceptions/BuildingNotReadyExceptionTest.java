package fiuba.algo3.model.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mporto on 28/06/15.
 */
public class BuildingNotReadyExceptionTest {

    @Test
    public void testGetMessage() throws Exception {
        BuildingNotReadyException exception = new BuildingNotReadyException();
        Assert.assertEquals("The building is not ready yet", exception.getMessage());
    }
}