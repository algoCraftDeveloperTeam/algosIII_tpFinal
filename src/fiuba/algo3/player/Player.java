package fiuba.algo3.player;

import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player {
    PlayerResources resources = new PlayerResources(200, 0);
    Population population = new Population();
    private List<BuildingInConstruction> buildingsInConstruction = new ArrayList<BuildingInConstruction>();
    private List<Building> buildings = new ArrayList<Building>();

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
            BuildingInConstruction buildingInConstruction = new BuildingInConstruction(buildingToBeConstructed);
            buildingsInConstruction.add(buildingInConstruction);
            return buildingInConstruction;
        }
        // We should add an Error if the requirements aren't met.
        throw new Exception();
    }

    // This methos should be private in the finished version
    public void addFinishedBuilding(Building building){
        this.buildings.add(building);
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
