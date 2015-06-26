package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.player.Player;

import java.util.Queue;

/**
 * Created by nsueiro on 03/06/15.
 */
public abstract class UnitCreator extends Building{

    Queue<UnitInTraining> trainingQueue;

    public UnitCreator(Player player, Coordinates coordinate) {
        super(player, coordinate);
    }

    abstract void trainUnit();

    public void getUnitInTraining() throws UnitNotReadyException {
        Unit current = this.trainingQueue.peek().getUnitBeingTrained();
        this.trainingQueue.remove();
        this.owner.addUnit(current, this.position);
    }

    @Override
    public boolean canCreate() {
        return true;
    }

}
