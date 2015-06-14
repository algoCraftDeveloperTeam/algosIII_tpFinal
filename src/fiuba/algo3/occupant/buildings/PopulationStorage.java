package fiuba.algo3.occupant.buildings;

import fiuba.algo3.player.Player;

/**
 * Created by nsueiro on 03/06/15.
 */
public abstract class PopulationStorage extends Building{
    public PopulationStorage(Player player, int coordX, int coordY){
        super(player, coordX, coordY);
        this.owner.addAvailablePopulation(5);
    }
}
