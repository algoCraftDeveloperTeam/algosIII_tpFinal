package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class StarPort extends Building {
    public StarPort(Player p){
        this.constructionCost = new Cost(150, 100);
        this.life = new Life(1300, 0);
        this.constructionTime = 10;
        this.owner = p;
    }

    @Override
    public boolean verifyRequiredBuilding(){
        return this.owner.allowStarPort();
    }
}
