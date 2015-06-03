package fiuba.algo3.buildings;

/**
 * Created by nsueiro on 03/06/15.
 */
public abstract class PopulationStorage extends Building{
    public PopulationStorage(){
        this.owner.addAvailablePopulation(5);
    }
}
