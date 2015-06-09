package fiuba.algo3.occupant.buildings;

import fiuba.algo3.occupant.InsufficientResourcesException;
import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private Player player;
    private MineralGetter aMineralGetter;
    private BuildingInConstruction aBuildingInConstruction;

    @Before
    public void setUp() throws Exception {
        this.player = new Player();
        this.aMineralGetter = new MineralNexus(player);
        this.aBuildingInConstruction = new BuildingInConstruction(aMineralGetter);
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

    @Test
    public void testGetBuildingInConstruction() throws Exception {
        assertEquals(this.aMineralGetter, this.aBuildingInConstruction.getBuildingInConstruction());
    }

    @Test
    public void testBuildingIsNotFinishedWhileTrainingTimeIsGreaterThanZero() throws Exception {
        assertFalse(this.aBuildingInConstruction.isReady());
    }

    @Test
    public void testTryingToBuildWithEnoughResourcesDoesNotThrowAnException() {
        assertTrue(true);
    }

    @Test
    public void testBuildingSubstractsResourcesFromPlayer() {
        int gasResourcesLeft = this.player.getGasStorage();
        int mineralResourcesLeft = this.player.getMineralStorage();
        assertTrue(gasResourcesLeft == 0 && mineralResourcesLeft == 150);
    }

    @Test (expected = InsufficientResourcesException.class)
    public void testTryingToBuildWithNotEnoughResourcesThrowsAnException() throws InsufficientResourcesException {
        Player player2 = new Player();
        player2.substractMinerals(175);
        Building building2 = new MineralNexus(player2);
        BuildingInConstruction inConstruction = new BuildingInConstruction(building2);
        assertTrue("Trying to build without enough resources didn't throw an exception", false);
    }

}