package fiuba.algo3.buildings;

import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private MineralGetter mn;
    private BuildingInConstruction bic;

    @Before
    public void setUp() throws Exception {
        this.mn = new MineralNexus(new Player());
        this.bic = new BuildingInConstruction(mn);
    }

    @Test
    public void testBuildingTimeEqualsToTheOneOfTheBuildingOnInitialize() throws Exception {
        assertEquals(this.mn.getConstructionTime(), this.bic.getRemainingTurns());
    }

    @Test
    public void testBuildingTimeAfterOneTurnDecreases() throws Exception {
        bic.passTurn();

        assertEquals(this.mn.getConstructionTime() - 1, this.bic.getRemainingTurns());
    }

    @Test
    public void testGetBuildingInConstruction() throws Exception {
        assertEquals(this.mn, this.bic.getBuildingInConstruction());
    }

    @Test
    public void testBuildingIsNotFinishedWhileTrainingTimeIsGreaterThanZero() throws Exception {
        assertFalse("", this.bic.isReady());
    }

}