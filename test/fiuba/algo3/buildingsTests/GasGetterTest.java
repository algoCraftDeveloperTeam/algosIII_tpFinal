package fiuba.algo3.buildingsTests;

import fiuba.algo3.buildings.GasGetter;
import fiuba.algo3.resources.Gas;
import org.junit.Test;
import junit.framework.Assert;
/**
 * Created by nsueiro on 29/05/15.
 */
public class GasGetterTest {
    @Test
    public void storageWhenInitializedIsZero(){
        GasGetter gg = new GasGetter();
        Assert.assertEquals(gg.getInStorage(), 0);
    }

    @Test
    public void addingToStorageUpdatesInStorageQuantity(){
        GasGetter gg = new GasGetter();
        gg.addToStorage(50);
        Assert.assertEquals(gg.getInStorage(), 50);
    }

    @Test
    public void collectingResetsQuantity(){
        GasGetter gg = new GasGetter();
        gg.addToStorage(50);
        Gas gas = gg.collectResources();
        Assert.assertEquals(gg.getInStorage(), 0);
    }

    @Test
    public void collectingReturnsAChunkOfMineralsOfSameSizeOfStorage(){
        GasGetter gg = new GasGetter();
        gg.addToStorage(50);
        Gas gas = gg.collectResources();
        Assert.assertEquals(gas.getQuantity(), 50);
    }
}
