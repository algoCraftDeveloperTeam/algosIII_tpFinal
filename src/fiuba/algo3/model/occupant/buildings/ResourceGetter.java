package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 29/05/15.
 */
public abstract class ResourceGetter extends Building{
    public int quantity = 10;

    public ResourceGetter(Player player, Coordinates coordinate){
        super(player, coordinate);
    }

    protected abstract void addToPlayerStorage();

    @Override
    public boolean canOccupyEarth(){
        return false;
    }

    @Override
    public void passTurn(){
        super.passTurn();
        this.addToPlayerStorage();
    }
}
