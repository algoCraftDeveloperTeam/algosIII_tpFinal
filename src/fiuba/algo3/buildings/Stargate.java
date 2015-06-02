package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

public class Stargate extends Building{

    public Stargate(Player p) {
    	this.owner = p;
        this.constructionCost = new Cost(150, 150);
        this.constructionTime = 10;
        this.life = new Life(600, 600);
    }

}