package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TemplarArchivesTest {

    private TemplarArchives aTemplarArchives;
    private Player owner;

    @Before
    public void setUp() throws Exception {
        this.owner = new Player((new AlgoCraftMap(1)).testMap());
        this.aTemplarArchives = new TemplarArchives(owner, new Coordinates(0, 0));
    }

    @Test
    public void testGetConstructionTime() {
        Assert.assertEquals(9, aTemplarArchives.getConstructionTime());
    }

    @Test
    public void testGetVitality() {
        Assert.assertEquals(500, aTemplarArchives.getVitality());
    }

    @Test
    public void testGetShield() {
        Assert.assertEquals(500, aTemplarArchives.getShield());
    }

    @Test
    public void testGetGasCost() {
        Assert.assertEquals(200, aTemplarArchives.getConstructionCost().getGasCost());
    }

    @Test
    public void testGetMineralCost() {
        Assert.assertEquals(150, aTemplarArchives.getConstructionCost().getMineralCost());
    }

}