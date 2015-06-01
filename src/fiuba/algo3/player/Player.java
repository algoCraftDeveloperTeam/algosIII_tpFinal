package fiuba.algo3.player;

import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player {
    PlayerResources resources = new PlayerResources(200, 0);
    Population population = new Population();

    public int getGasStorage(){
        return resources.getGasStorage();
    }

    public int getMineralStorage(){
        return resources.getMineralStorage();
    }

    public void addGas(int n){
        resources.addGas(n);
    }

    public void addMinerals(int n){
        resources.addMinerals(n);
    }

    public int getAvailablePopulation() {
        return population.getAvailablePopulation();
    }

    public void addAvailablePopulation(int i) {
        this.population.addAvailablePopulation(5);
    }
}
