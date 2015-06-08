package fiuba.algo3.player;

import fiuba.algo3.occupant.InsufficientResourcesException;
import fiuba.algo3.occupant.MissingRequiredBuildingsException;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;

import java.util.ArrayList;
import java.util.HashMap;
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
    HashMap<Class<?>, List<Building>> buildings2 = new HashMap<>();

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

    public BuildingInConstruction build(Building buildingToBeConstructed)
            throws InsufficientResourcesException, MissingRequiredBuildingsException {
        try {
            this.verifyRequirements(buildingToBeConstructed);
            BuildingInConstruction buildingInConstruction = new BuildingInConstruction(buildingToBeConstructed);
            buildingsInConstruction.add(buildingInConstruction);
            return buildingInConstruction;
        }catch (InsufficientResourcesException ex){
            throw ex;
        }catch(MissingRequiredBuildingsException ex){
            throw ex;
        }
    }

    // This method should be private in the finished version
    public void addFinishedBuilding(Building building){
        this.buildings.add(building);
    }

    public void addFinishedBuilding2(Building building){
        // TO DO: add building method getName.
        if(this.buildings2.containsKey(building.getClass())){
            this.buildings2.get(building.getClass()).add(building);
        }else{
            List<Building> buildingsOfTheType = new ArrayList<Building>();
            buildingsOfTheType.add(building);
            this.buildings2.put(building.getClass(), buildingsOfTheType);
        }
    }
    private boolean hasBuilding(Class building){
        if(this.buildings2.containsKey(building)){
            return !this.buildings2.get(building).isEmpty();
        }
        return false;
    }

    private void verifyRequirements(Building buildingToBeConstructed) throws InsufficientResourcesException,
            MissingRequiredBuildingsException {
        try {
            this.verifyCost(buildingToBeConstructed.getConstructionCost());
        }catch (InsufficientResourcesException ex){
            throw ex;
        }

        if(!buildingToBeConstructed.verifyRequiredBuilding()) throw new MissingRequiredBuildingsException();

    }

    private void verifyCost(Cost constructionCost) throws InsufficientResourcesException{
        boolean mineralStatus = this.resources.getMineralStorage() >= constructionCost.getMineralCost();
        boolean gasStatus = this.resources.getGasStorage() >= constructionCost.getGasCost();

        if(!(mineralStatus && gasStatus)) throw new InsufficientResourcesException();
    }

    private void verifyRequiredBuildings(List<Class<?>> requiredBuildings) throws MissingRequiredBuildingsException{
        Iterator<Class<?>> requiredBuilding = requiredBuildings.iterator();
        while (requiredBuilding.hasNext()){
            if(!this.hasBuilding(requiredBuilding.next().getClass())) throw new MissingRequiredBuildingsException();
        }
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
