package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 28/05/15.
 */
public abstract class MineralGetter extends ResourceGetter {
    public MineralGetter(Player player) {
        super(player);
        this.constructionCost = new Cost(50, 0);
        this.constructionTime = 4;
    }
    @Override
    public void addToPlayerStorage(){
        owner.addMinerals(quantity);
    }
    @Override
    public boolean isMineralBuildable(){
    	return true;
    }

}
