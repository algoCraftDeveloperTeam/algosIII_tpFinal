package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 01/06/15.
 */
public class TerranFactory extends Building{
    public TerranFactory(Player p){
        this.owner = p;
        this.constructionTime = 12;
        this.constructionCost = new Cost(200, 100);
        this.life = new Life(1250, 0);
    }
}
