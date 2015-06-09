package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.DestinationIsOccupiedException;
import fiuba.algo3.exceptions.InvalidMovementException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.player.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 09/06/15.
 */
public class MovementTest {

    private Unit unit;
    private AlgoCraftMap algoCraftMap;

    @Before
    public void setUp() throws Exception {
        unit = new Marine();
        algoCraftMap = new AlgoCraftMap(20);
    }

    @Test
    public void testSetAValidPosition()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        unit.setPosition(1, 1, algoCraftMap);
    }

    @Test(expected = KeyDoesNotExistsException.class)
    public void testSetAnInvalidPositionShouldRaiseKeyDoesNotExistsException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        unit.setPosition(-1, -1, algoCraftMap);
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testSetPositionToAnOccupiedOneByAnUnitShouldRaiseCannotOccupyTileException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        Unit unit1 = new Marine();
        unit1.setPosition(1, 1, algoCraftMap);
        unit.setPosition(1, 1, algoCraftMap);
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testSetPositionToAnOccupiedOneByABuildingShouldRaiseCannotOccupyTileException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        Player player = new Player();
        Building building = new Barracks(player);
        building.setPosition(1, 1, algoCraftMap);
        unit.setPosition(1, 1, algoCraftMap);
    }

    @Test
    public void testUnitMovesToAValidPositionWithinItsMovementRange()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        unit.setPosition(1, 1, algoCraftMap);
        unit.move(2, 2, algoCraftMap);
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnInvalidPositionWithinItsMovementRangeShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        unit.setPosition(1, 1, algoCraftMap);
        unit.move(-1, -1, algoCraftMap);
    }

    // Maybe the exception to be raised should be DestinationIsOccupiedException
    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByAnUnitShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        Unit unit1 = new Marine();
        unit1.setPosition(2, 2, algoCraftMap);
        unit.setPosition(1, 1, algoCraftMap);
        unit.move(2, 2, algoCraftMap);
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByABuildingShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        Player player = new Player();
        Building building = new Barracks(player);
        building.setPosition(2, 2, algoCraftMap);
        unit.setPosition(1, 1, algoCraftMap);
        unit.move(2, 2, algoCraftMap);
    }
}
