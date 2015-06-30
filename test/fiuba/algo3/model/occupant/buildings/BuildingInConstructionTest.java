package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.exceptions.BuildingNotReadyException;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 30/05/15.
 */
public class BuildingInConstructionTest {

    private Player player;
    private MineralGetter aMineralGetter;
    private BuildingInConstruction aBuildingInConstruction;

    @Before
    public void setUp() throws Exception {
        this.player = new Player((new AlgoCraftMap(1)).testMap());
        this.aMineralGetter = new MineralNexus(player, new Coordinates(0, 0));
        this.aBuildingInConstruction = new BuildingInConstruction(aMineralGetter, new Coordinates(0, 0));
    }

    @Test
    public void testBuildingTimeEqualsToTheOneOfTheBuildingOnInitialize() throws Exception {
        Assert.assertEquals(this.aMineralGetter.getConstructionTime(), this.aBuildingInConstruction.getRemainingTurns());
    }

    @Test
    public void testBuildingTimeAfterOneTurnDecreases() throws Exception {
        aBuildingInConstruction.passTurn();

        Assert.assertEquals(this.aMineralGetter.getConstructionTime() - 1, this.aBuildingInConstruction.getRemainingTurns());
    }

    @Test (expected = BuildingNotReadyException.class)
    public void testGetBuildingInConstructionRaisesAnExceptionWhenNotReady() throws Exception {
        Assert.assertEquals(this.aMineralGetter, this.aBuildingInConstruction.getBuildingInConstruction());
    }

    @Test
    public void testBuildingIsNotFinishedWhileTrainingTimeIsGreaterThanZero() throws Exception {
        Assert.assertFalse(this.aBuildingInConstruction.isReady());
    }

    @Test
    public void testVitalityIsTheSameAsBuildingBeingConstructed() {
        Assert.assertEquals(250, this.aBuildingInConstruction.getVitality());
    }

    @Test
    public void testMineralGeterGetterInConstructionCannotOccupyGas() {
        Assert.assertFalse(this.aBuildingInConstruction.canOccupyGas());
    }

    @Test
    public void testCanCreate() throws Exception {
        Assert.assertFalse(aBuildingInConstruction.canCreate());
    }

    @Test
    public void testCanAttack() throws Exception {
        Assert.assertFalse(aBuildingInConstruction.canAttack());
    }

    @Test
    public void testCanMove() throws Exception {
        Assert.assertFalse(aBuildingInConstruction.canMove());
    }

    @Test
    public void testGetOwner() throws Exception {
        Assert.assertEquals(player, aBuildingInConstruction.getOwner());
    }

    @Test
    public void testGetPosition() throws Exception {
        Assert.assertEquals(new Coordinates(0, 0), aBuildingInConstruction.getPosition());
    }
}