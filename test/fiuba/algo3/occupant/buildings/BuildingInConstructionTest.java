package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private MineralGetter aMineralGetter;
    private BuildingInConstruction aBuildingInConstruction;

    @Before
    public void setUp() throws Exception {
        this.aMineralGetter = new MineralNexus(new Player());
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

}