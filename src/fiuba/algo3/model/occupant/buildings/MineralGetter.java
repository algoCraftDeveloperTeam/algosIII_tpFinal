package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 28/05/15.
 */
public abstract class MineralGetter extends ResourceGetter {
    public MineralGetter(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.constructionCost = new Cost(50, 0);
        this.constructionTime = 4;
    }
    @Override
    protected void addToPlayerStorage(){
        owner.addMinerals(quantity);
    }
    @Override
    public boolean canOccupyMineral(){
    	return true;
    }
}
