package fiuba.algo3.player;

import fiuba.algo3.exceptions.DestinationIsOccupiedException;
import fiuba.algo3.exceptions.InsufficientResourcesException;
import fiuba.algo3.exceptions.MissingRequiredBuildingsException;
import fiuba.algo3.game.TurnAware;
import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.PlayerResources;
import fiuba.algo3.gameVariables.Population;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.occupant.buildings.BuildingInConstruction;
import fiuba.algo3.occupant.units.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nsueiro on 29/05/15.
 */
public class Player implements TurnAware{

    PlayerResources resources;
    Population population;
    private List<BuildingInConstruction> buildingsInConstruction;
    Map<Class<?>, List<Building>> buildings;
    List <Unit> units;
    AlgoCraftMap algoCraftMap;

    public Player(AlgoCraftMap map){
        resources = new PlayerResources(200, 0);
        population = new Population();
        buildingsInConstruction = new ArrayList<BuildingInConstruction>();
        buildings = new HashMap<Class<?>, List<Building>>();
        units = new ArrayList<Unit>();
        algoCraftMap = map;
    }

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
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException {
        try {
            if (algoCraftMap.isOccupied(buildingToBeConstructed.getPosition())) {
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
        if(this.buildings.containsKey(building.getClass())){
            this.buildings.get(building.getClass()).add(building);
        }else{
            List<Building> buildingsOfTheType = new ArrayList<Building>();
            buildingsOfTheType.add(building);
            this.buildings.put(building.getClass(), buildingsOfTheType);
        }
    }
    private boolean hasBuilding(Class building) {
        return this.buildings.containsKey(building) && !this.buildings.get(building).isEmpty();
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
        for(List list : buildings.values()) {
            for(Object building : list){
                TurnAware buildingAsTurnAware = (TurnAware) building;
                buildingAsTurnAware.passTurn();
            }
        }
    }

    public void addUnit(Unit unit, Coordinates coord){
        this.units.add(unit);
    }
}
