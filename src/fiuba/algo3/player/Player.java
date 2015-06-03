package fiuba.algo3.player;

import fiuba.algo3.buildings.Building;
import fiuba.algo3.buildings.BuildingInConstruction;
import fiuba.algo3.buildings.NullBuilding;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player {
    PlayerResources resources = new PlayerResources(200, 0);
    Population population = new Population();
    List buildings = new ArrayList();

    public int getGasStorage(){
        return this.resources.getGasStorage();
    }

    public int getMineralStorage(){
        return this.resources.getMineralStorage();
    }

    public void addGas(int n){
        this.resources.addGas(n);
    }

    public void addMinerals(int n){
        this.resources.addMinerals(n);
    }

    public int getAvailablePopulation() {
        return this.population.getAvailablePopulation();
    }

    public void addAvailablePopulation(int i) {
        this.population.addAvailablePopulation(i);
    }

    public BuildingInConstruction build(Building buildingToBeConstructed) throws Exception {
        if(this.verifyRequirements(buildingToBeConstructed)){
            buildings.add(buildingToBeConstructed);
            BuildingInConstruction buildingInConstruction = new BuildingInConstruction(buildingToBeConstructed);
            return buildingInConstruction;
        }
        // We should add an Error if the requirements aren't met.
        throw new Exception();
    }

    private boolean verifyRequirements(Building buildingToBeConstructed) {
        return (this.verifyCost(buildingToBeConstructed.getConstructionCost()) && buildingToBeConstructed.verifyRequiredBuilding());
    }

    private boolean verifyCost(Cost constructionCost) {
        boolean mineralStatus = this.resources.getMineralStorage() >= constructionCost.getMineralCost();
        boolean gasStatus = this.resources.getGasStorage() >= constructionCost.getGasCost();

        return mineralStatus && gasStatus;
    }

    public void substractMinerals(int mineralCost) {
        this.resources.substractMinerals(mineralCost);
    }

    public void substractGas(int gasCost) {
        this.resources.substractGas(gasCost);
    }

    public boolean allowTerranFactory(){
        boolean founded = false;
        Iterator it = buildings.iterator();
        while(it.hasNext() && !founded){
            Building iElement = (Building) it.next();
            founded = iElement.allowBuildTerranFactory();
        }
        return founded;
    }

    public boolean allowStarPort(){
        boolean founded = false;
        Iterator it = buildings.iterator();
        while(it.hasNext() && !founded){
            Building iElement = (Building) it.next();
            founded = iElement.allowBuildStarPort();
        }
        return founded;
    }

    public boolean allowStargate(){
        boolean founded = false;
        Iterator it = buildings.iterator();
        while(it.hasNext() && !founded){
            Building iElement = (Building) it.next();
            founded = iElement.allowBuildStargate();
        }
        return founded;
    }

    public boolean allowTemplarArchives(){
        boolean founded = false;
        Iterator it = buildings.iterator();
        while(it.hasNext() && !founded){
            Building iElement = (Building) it.next();
            founded = iElement.allowBuildTemplarArchives();
        }
        return founded;
    }
}
