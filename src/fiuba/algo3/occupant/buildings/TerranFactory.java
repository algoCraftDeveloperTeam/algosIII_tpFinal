
package fiuba.algo3.occupant.buildings;

import fiuba.algo3.exceptions.UnitNotReadyException;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.Goliath;
import fiuba.algo3.occupant.units.UnitInTraining;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactory extends Building implements UnitCreator {

    private Queue<UnitInTraining> trainingQueue;

    public TerranFactory(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.requiredBuildings.add(Barracks.class);
        this.constructionTime = 12;
        this.constructionCost = new Cost(200, 100);
        this.life = new Life(1250, 0);
        this.trainingQueue = new LinkedList<UnitInTraining>();
    }

    @Override
    public void trainUnit() {
        Goliath aGoliathToBeTrained = new Goliath();
        UnitInTraining aGoliathInTraining = new UnitInTraining(aGoliathToBeTrained);
        this.trainingQueue.add(aGoliathInTraining);
    }

    @Override
    public void passTurn() {
        super.passTurn();
        UnitInTraining firstUnit = this.trainingQueue.peek();
        firstUnit.passTurn();
    }

    @Override
    public void getUnitInTraining() throws UnitNotReadyException {
        Unit current = this.trainingQueue.peek().getUnitBeingTrained();
        this.trainingQueue.remove();
        this.owner.addUnit(current, this.position);
    }
}