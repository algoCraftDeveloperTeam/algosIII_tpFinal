package fiuba.algo3.combat;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
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
        algoCraftMap = AlgoCraftMap.generateTestMap();
        player = new Player(algoCraftMap);
        access = new Access(player, new Coordinates(0, 0));
        building = new BuildingInConstruction(access, new Coordinates(0, 0));
        marine = new Marine();
    }

    @Test
    public void testMarineAttacksBuildingWithinRange() throws Exception {
        marine.setPosition(algoCraftMap, new Coordinates(1,1));
        marine.attack(building);
        // 500 (building's shield) - 6 (marine's attack) = 494
        Assert.assertEquals(494, building.getShield());
    }

    @Test
    public void testMarineAttacksBuildingOutOfRange() throws Exception {
        marine.setPosition(algoCraftMap, new Coordinates(5,5));
        building.setPosition(15,16,algoCraftMap);
        marine.attack(building);
        
        Assert.assertEquals(500, building.getShield());
    }
}
