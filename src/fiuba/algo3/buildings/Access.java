package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

public class Access extends Building{

    public Access(Player p) {
    	this.owner = p;
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 8;
        this.life = new Life(500, 500);
    }

    @Override
    public boolean allowBuildStargate(){
        return true;
    }
}