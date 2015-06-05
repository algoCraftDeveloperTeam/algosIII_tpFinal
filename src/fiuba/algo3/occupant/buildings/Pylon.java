package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 31/05/15.
 */
public class Pylon extends PopulationStorage{

    public Pylon(Player player) {
        super(player);
        this.constructionTime = 5;
        this.constructionCost = new Cost(100, 0);
        this. life = new Life(250, 250);
    }
}
