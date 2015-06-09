package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

public class Stargate extends Building{

    public Stargate(Player player) {
    	super(player);
        this.constructionCost = new Cost(150, 150);
        this.constructionTime = 10;
        this.life = new Life(600, 600);
    }
}