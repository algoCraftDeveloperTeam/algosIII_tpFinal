package fiuba.algo3.buildingsTests;

import fiuba.algo3.buildings.MineralGetter;
import fiuba.algo3.resources.Mineral;
import junit.framework.Assert;
import org.junit.Test;
/**
 * Created by nsueiro on 28/05/15.
 */
public class MineralGetterTest {

    @Test
    public void storageWhenInitializedIsZero(){
        MineralGetter mg = new MineralGetter();
        Assert.assertEquals(mg.getInStorage(), 0);
    }

    @Test
    public void addingToStorageUpdatesInStorageQuantity(){
        MineralGetter mg = new MineralGetter();
        mg.addToStorage(50);
        Assert.assertEquals(mg.getInStorage(), 50);
    }

    @Test
    public void collectingResetsQuantity(){
        MineralGetter mg = new MineralGetter();
        mg.addToStorage(50);
        Mineral mineral = mg.collectResources();
        Assert.assertEquals(mg.getInStorage(), 0);
    }

    @Test
    public void collectingReturnsAChunkOfMineralsOfSameSizeOfStorage(){
        MineralGetter mg = new MineralGetter();
        mg.addToStorage(50);
        Mineral mineral = mg.collectResources();
        Assert.assertEquals(mineral.getQuantity(), 50);
    }
}