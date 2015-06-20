package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.InvalidMovementException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.occupant.buildings.Barracks;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.units.Marine;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.player.Player;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mporto on 09/06/15.
 */
public class MovementTest {

    private Unit unit;
    private Coordinates position;
    private AlgoCraftMap algoCraftMap;

    @Before
    public void setUp() throws Exception {
        unit = new Marine();
        algoCraftMap = new AlgoCraftMap(20);
    }

    @Test
    public void testSetAValidPosition()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
    }

    @Test(expected = KeyDoesNotExistsException.class)
    public void testSetAnInvalidPositionShouldRaiseKeyDoesNotExistsException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        position = new Coordinates(-1, -1);
        unit.setPosition(algoCraftMap, position);
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testSetPositionToAnOccupiedOneByAnUnitShouldRaiseCannotOccupyTileException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        position = new Coordinates(1, 1);
        Unit unit1 = new Marine();
        unit1.setPosition(algoCraftMap, position);
        unit.setPosition(algoCraftMap, position);
    }

    @Test(expected = CannotOccupyTileException.class)
    public void testSetPositionToAnOccupiedOneByABuildingShouldRaiseCannotOccupyTileException()
            throws KeyDoesNotExistsException, CannotOccupyTileException {
        Player player = new Player(new AlgoCraftMap(20));
        Building building = new Barracks(player, new Coordinates(0, 0));
        building.setPosition(1, 1, algoCraftMap);
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
    }

    @Test
    public void testUnitMovesToAValidPositionWithinItsMovementRange()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(2, 2, algoCraftMap);
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnInvalidPositionWithinItsMovementRangeShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(-1, -1, algoCraftMap);
    }

    // Maybe the exception to be raised should be DestinationIsOccupiedException
    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByAnUnitShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        Unit unit1 = new Marine();
        unit1.setPosition(algoCraftMap, new Coordinates(2,2));
        unit.setPosition(algoCraftMap, position);
        unit.move(2, 2, algoCraftMap);
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByABuildingShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        Player player = new Player(new AlgoCraftMap(20));
        Building building = new Barracks(player, new Coordinates(0, 0));
        building.setPosition(2, 2, algoCraftMap);
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(2, 2, algoCraftMap);
    }
}
