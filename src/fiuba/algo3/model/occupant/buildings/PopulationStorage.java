package fiuba.algo3.model.occupant.buildings;

import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.player.Player;

/**
 * Created by nsueiro on 03/06/15.
 */
public abstract class PopulationStorage extends Building{
    public PopulationStorage(Player player, Coordinates coordinate){
        super(player, coordinate);
    }

    @Override
    public void applyEffect(){
        this.owner.addAvailablePopulation(5);
    }
}
