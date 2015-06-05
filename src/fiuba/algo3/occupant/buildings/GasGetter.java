package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class GasGetter extends ResourceGetter{
    public GasGetter(Player player) {
        super(player);
        this.constructionCost = new Cost(100, 0);
        this.constructionTime = 4;
    }
    @Override
    public void addToPlayerStorage(){
        owner.addGas(quantity);
    }
    @Override
    public boolean canOccupyGas(){
    	return true;
    }
}
