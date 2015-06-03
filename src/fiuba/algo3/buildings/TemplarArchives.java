package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

public class TemplarArchives extends Building{

    public TemplarArchives(Player player) {
        super(player);
        this.constructionCost = new Cost(150, 200);
        this.constructionTime = 9;
        this.life = new Life(500, 500);
    }

    @Override
    public boolean verifyRequiredBuilding(){
        return this.owner.allowTemplarArchives();
    }

}