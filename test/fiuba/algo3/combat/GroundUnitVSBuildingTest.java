package fiuba.algo3.combat;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.occupant.buildings.Access;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
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
    private Access access;
    private Player player;
    private BuildingInConstruction building;
    private AlgoCraftMap algoCraftMap;

    @Before
    public void setUp() throws Exception {
        player = new Player(new AlgoCraftMap(20));
        access = new Access(player, 0, 0);
        building = new BuildingInConstruction(access, 0, 0);
        marine = new Marine();
        algoCraftMap = new AlgoCraftMap(20);
    }

    @Test
    public void testMarineAttacksBuildingWithinRange() throws Exception {
        marine.setPosition(1,1,algoCraftMap);
        marine.attack(building);
        // 500 (building's shield) - 6 (marine's attack) = 494
        Assert.assertEquals(494, building.getShield());
    }

    @Test
    public void testMarineAttacksBuildingOutOfRange() throws Exception {
        marine.setPosition(5,5,algoCraftMap);
        building.setPosition(15,16,algoCraftMap);
        marine.attack(building);
        
        Assert.assertEquals(500, building.getShield());
    }
}
