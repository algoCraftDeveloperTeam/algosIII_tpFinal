package fiuba.algo3.player;

import fiuba.algo3.exceptions.DestinationIsOccupiedException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.MissingRequiredBuildingsException;
import fiuba.algo3.game.TurnAware;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;

import java.util.*;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player implements TurnAware{
    PlayerResources resources = new PlayerResources(200, 0);
    Population population = new Population();
    private List<BuildingInConstruction> buildingsInConstruction = new ArrayList<BuildingInConstruction>();
    Map<Class<?>, List<Building>> buildings2 = new HashMap<Class<?>, List<Building>>();

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

    public BuildingInConstruction build(Building buildingToBeConstructed, AlgoCraftMap map)
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException {
        try {
            if (map.isOccupied(buildingToBeConstructed.getPosition())) {
                throw new DestinationIsOccupiedException();
            }
            this.verifyRequirements(buildingToBeConstructed);
            int coordX = buildingToBeConstructed.getPosition().getX();
            int coordY = buildingToBeConstructed.getPosition().getY();
            BuildingInConstruction buildingInConstruction = new BuildingInConstruction(buildingToBeConstructed, coordX, coordY);
            buildingsInConstruction.add(buildingInConstruction);
            return buildingInConstruction;
        }catch (InsufficientResourcesException ex){
            throw ex;
        }catch(MissingRequiredBuildingsException ex){
            throw ex;
        }
    }

    public void addFinishedBuilding(Building building){
        if(this.buildings2.containsKey(building.getClass())){
            this.buildings2.get(building.getClass()).add(building);
        }else{
            List<Building> buildingsOfTheType = new ArrayList<Building>();
            buildingsOfTheType.add(building);
            this.buildings2.put(building.getClass(), buildingsOfTheType);
        }
    }
    private boolean hasBuilding(Class building) {
        return this.buildings2.containsKey(building) && !this.buildings2.get(building).isEmpty();
    }

    private void verifyRequirements(Building buildingToBeConstructed) throws InsufficientResourcesException,
            MissingRequiredBuildingsException {
        try {
            this.verifyRequiredBuildings(buildingToBeConstructed.getRequiredBuildings());
            this.verifyCost(buildingToBeConstructed.getConstructionCost());
        }catch (InsufficientResourcesException ex){
            throw ex;
        }catch (MissingRequiredBuildingsException ex){
            throw ex;
        }


    }

    private void verifyCost(Cost constructionCost) throws InsufficientResourcesException{
        boolean mineralStatus = this.resources.getMineralStorage() >= constructionCost.getMineralCost();
        boolean gasStatus = this.resources.getGasStorage() >= constructionCost.getGasCost();

        if(!(mineralStatus && gasStatus)) throw new InsufficientResourcesException();
    }

    private void verifyRequiredBuildings(List<Class<?>> requiredBuildings) throws MissingRequiredBuildingsException{
        for (Class<?> requiredBuilding1 : requiredBuildings) {
            if (!this.hasBuilding(requiredBuilding1)) {
                throw new MissingRequiredBuildingsException();
            }
        }
    }
    public void substractMinerals(int mineralCost) {
        this.resources.substractMinerals(mineralCost);
    }

    public void substractGas(int gasCost) {
        this.resources.substractGas(gasCost);
    }

    @Override
    public void passTurn() {
        for(TurnAware building : buildingsInConstruction){
            building.passTurn();
        }
        // This is awful. Must find a better way to iterate over hashMap values
        // without casting.
        for(List list : buildings2.values()) {
            for(Object building : list){
                TurnAware buildingAsTurnAware = (TurnAware) building;
                buildingAsTurnAware.passTurn();
            }
        }
    }
}
