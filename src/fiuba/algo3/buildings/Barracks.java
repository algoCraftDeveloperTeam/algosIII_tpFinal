package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class Barracks extends Building{

    public Barracks(Player owner) {
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 12;
        this.life = new Life(1000, 0);
    }

    public void trainMarine() {
    }
}
