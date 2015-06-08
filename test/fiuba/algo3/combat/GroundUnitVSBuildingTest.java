package fiuba.algo3.combat;

import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.occupant.buildings.MineralNexus;
import fiuba.algo3.occupant.units.CombatUnit;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 04/06/15.
 */
public class GroundUnitVSBuildingTest {

    private CombatUnit marine;
    private MineralNexus mineralNexus;
    private Player player;
    private BuildingInConstruction building;

    @Before
    public void setUp() throws Exception {
        player = new Player();
        mineralNexus = new MineralNexus(player);
        building = new BuildingInConstruction(mineralNexus);
        marine = new Marine();
    }

    @Test
    public void testMarineAttacksBuildingWithinRange() throws Exception {
        marine.move(1, 1);
        building.setPosition(2, 2);
        marine.attack(building);
        // 250 (building's shield) - 6 (marine's attack) = 244
        int expectedRemainingShield = 244;

        Assert.assertEquals(expectedRemainingShield, building.getShield());
    }

    @Test
    public void testMarineAttacksBuildingOutOfRange() throws Exception {
        marine.move(11, 11);
        building.setPosition(15, 16);
        marine.attack(building);

        Assert.assertEquals(250, building.getShield());
    }
}
