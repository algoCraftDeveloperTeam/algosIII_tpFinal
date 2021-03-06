package fiuba.algo3.model.map;

import fiuba.algo3.model.exceptions.CannotOccupyTileException;
import fiuba.algo3.model.exceptions.InvalidMovementException;
import fiuba.algo3.model.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.model.occupant.buildings.Barracks;
import fiuba.algo3.model.occupant.buildings.Building;
import fiuba.algo3.model.occupant.units.Marine;
import fiuba.algo3.model.occupant.units.Unit;
import fiuba.algo3.model.player.Player;
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
        algoCraftMap = (new AlgoCraftMap(1)).testMap();
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
        Player player = new Player(algoCraftMap);
        Building building = new Barracks(player, new Coordinates(0, 0));
        position = new Coordinates(1, 1);
        building.setPosition(algoCraftMap, position);
        unit.setPosition(algoCraftMap, position);
    }

    @Test
    public void testUnitMovesToAValidPositionWithinItsMovementRange()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(algoCraftMap, new Coordinates(2,2));
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnInvalidPositionWithinItsMovementRangeShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(algoCraftMap, new Coordinates(-1, -1));
    }

    // Maybe the exception to be raised should be DestinationIsOccupiedException
    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByAnUnitShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        position = new Coordinates(1, 1);
        Unit unit1 = new Marine();
        unit1.setPosition(algoCraftMap, new Coordinates(2,2));
        unit.setPosition(algoCraftMap, position);
        unit.move(algoCraftMap, new Coordinates(2, 2));
    }

    @Test(expected = InvalidMovementException.class)
    public void testUnitMovesToAnOccupiedPositionByABuildingShouldRaiseInvalidMovementException()
            throws KeyDoesNotExistsException, CannotOccupyTileException, InvalidMovementException {
        Player player = new Player(algoCraftMap);
        Building building = new Barracks(player, new Coordinates(0, 0));
        building.setPosition(algoCraftMap, new Coordinates(2, 2));
        position = new Coordinates(1, 1);
        unit.setPosition(algoCraftMap, position);
        unit.move(algoCraftMap, new Coordinates(2,2));
    }
}
