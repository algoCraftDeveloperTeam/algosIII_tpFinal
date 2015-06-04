package fiuba.algo3.buildings;

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

    @Override
    public boolean verifyRequiredBuilding(){
        return this.owner.allowStargate();
    }

    @Override
    public boolean allowBuildTemplarArchives(){
        return true;
    }


}