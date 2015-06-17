package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import fiuba.algo3.map.AlgoCraftMap;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private Player player;
    private MineralGetter aMineralGetter;
    private BuildingInConstruction aBuildingInConstruction;

    @Before
    public void setUp() throws Exception {
        this.player = new Player(new AlgoCraftMap(20));
        this.aMineralGetter = new MineralNexus(player);
        this.aBuildingInConstruction = new BuildingInConstruction(aMineralGetter, 0, 0);
    }

    @Test
    public void testBuildingTimeEqualsToTheOneOfTheBuildingOnInitialize() throws Exception {
        assertEquals(this.aMineralGetter.getConstructionTime(), this.aBuildingInConstruction.getRemainingTurns());
    }

    @Test
    public void testBuildingTimeAfterOneTurnDecreases() throws Exception {
        aBuildingInConstruction.passTurn();

        assertEquals(this.aMineralGetter.getConstructionTime() - 1, this.aBuildingInConstruction.getRemainingTurns());
    }
/*
    @Test
    public void testGetBuildingInConstruction() throws Exception {
        assertEquals(this.aMineralGetter, this.aBuildingInConstruction.getBuildingInConstruction());
    }
*/
    @Test
    public void testBuildingIsNotFinishedWhileTrainingTimeIsGreaterThanZero() throws Exception {
        assertFalse(this.aBuildingInConstruction.isReady());
    }

    @Test
    public void testBuildingSubstractsResourcesFromPlayer() {
        int gasResourcesLeft = this.player.getGasStorage();
        int mineralResourcesLeft = this.player.getMineralStorage();
        assertTrue(gasResourcesLeft == 0 && mineralResourcesLeft == 150);
    }
    
}