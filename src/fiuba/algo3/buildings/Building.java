package fiuba.algo3.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;

/**
 * Created by mporto on 30/05/15.
 */
public class Building {
    Cost constructionCost;
    int constructionTime;
    Life life;
    Player owner;
    public boolean isNil(){
    	return false;
    }
}
