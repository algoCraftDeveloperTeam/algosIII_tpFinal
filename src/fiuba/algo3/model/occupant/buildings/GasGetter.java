package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.gameVariables.Cost;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class GasGetter extends ResourceGetter{
    public GasGetter(Player player, Coordinates coordinate) {
        super(player, coordinate);
        this.constructionCost = new Cost(100, 0);
        this.constructionTime = 4;
    }

    @Override
    protected void addToPlayerStorage(){
        owner.addGas(quantity);
    }

    @Override
    public boolean canOccupyGas(){
    	return true;
    }
}
