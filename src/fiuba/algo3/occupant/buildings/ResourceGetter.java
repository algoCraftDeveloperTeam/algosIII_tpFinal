package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class ResourceGetter extends Building{
    public int quantity = 10;
    public ResourceGetter(Player player){
        super(player);
    }
    public abstract void addToPlayerStorage();
    @Override
    public boolean canOccupyEarth(){
        return false;
    }
    // TO DO: receiveAttack
}
