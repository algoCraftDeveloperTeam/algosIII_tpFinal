package fiuba.algo3.player;

import fiuba.algo3.exceptions.*;
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
    String playerName;

    public Player(AlgoCraftMap map){
        resources = new PlayerResources(200, 0);
        population = new Population();
        buildingsInConstruction = new ArrayList<BuildingInConstruction>();
        buildings = new HashMap<Class<?>, List<Building>>();
        units = new ArrayList<Unit>();
        algoCraftMap = map;
    }

    public Player(AlgoCraftMap map, String name){
        resources = new PlayerResources(400, 0);
        population = new Population();
        buildingsInConstruction = new ArrayList<BuildingInConstruction>();
        buildings = new HashMap<Class<?>, List<Building>>();
        units = new ArrayList<Unit>();
        algoCraftMap = map;
        playerName = name;
    }

    public int getGasStorage(){
        return this.resources.getGasStorage();
    }

    public int getMineralStorage(){
        return this.resources.getMineralStorage();
    }

    public String getName(){
        return playerName;
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

    public int getUsedPopulation() {
        return this.population.getUsedPopulation();
    }
    public void addAvailablePopulation(int i) {
        this.population.addAvailablePopulation(i);
    }

    public void addUsedPopulation(int i) {
        this.population.addUsedPopulation(i);
    }

    public BuildingInConstruction build(Building buildingToBeConstructed)
            throws InsufficientResourcesException, MissingRequiredBuildingsException, DestinationIsOccupiedException, CannotOccupyTileException, KeyDoesNotExistsException {

        this.verifyRequirements(buildingToBeConstructed);
        int coordX = buildingToBeConstructed.getPosition().getX();
        int coordY = buildingToBeConstructed.getPosition().getY();
        BuildingInConstruction buildingInConstruction = new BuildingInConstruction(buildingToBeConstructed, new Coordinates(coordX, coordY));
        this.algoCraftMap.put(buildingInConstruction, new Coordinates(coordX, coordY));
        buildingsInConstruction.add(buildingInConstruction);
        this.subtractMinerals(buildingToBeConstructed.getConstructionCost().getMineralCost());
        this.subtractGas(buildingToBeConstructed.getConstructionCost().getGasCost());
        return buildingInConstruction;
    }

    public void addFinishedBuilding(Building building){
        if(this.buildings.containsKey(building.getClass())){
            this.buildings.get(building.getClass()).add(building);
        }else{
            List<Building> buildingsOfTheType = new ArrayList<Building>();
            buildingsOfTheType.add(building);
            this.buildings.put(building.getClass(), buildingsOfTheType);
        }
        this.algoCraftMap.clearTile(building.getPosition());
        try {
            this.algoCraftMap.put(building, building.getPosition());
        } catch (CannotOccupyTileException | KeyDoesNotExistsException e) {}
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
    public void subtractMinerals(int mineralCost) {
        this.resources.subtractMinerals(mineralCost);
    }

    public void subtractGas(int gasCost) {
        this.resources.subtractGas(gasCost);
    }

    @Override
    public void passTurn() {
        for(TurnAware building : buildingsInConstruction){
            BuildingInConstruction bic = (BuildingInConstruction) building;
            if(bic.isReady()){
                try {
                    Building ready = bic.getBuildingInConstruction();
                    this.addFinishedBuilding(ready);
                } catch (BuildingNotReadyException ex){}
            }
            building.passTurn();
        }
        for(List list : buildings.values()) {
            for(Object building : list){
                TurnAware buildingAsTurnAware = (TurnAware) building;
                buildingAsTurnAware.passTurn();
            }
        }
        for(Unit unit : this.units){
            unit.passTurn();
        }
    }

    public void addUnit(Unit unit, Coordinates coord){
        unit.setOwner(this);
        this.units.add(unit);
        this.algoCraftMap.locate(unit, coord);
    }

    public void removeBuilding(Building building){
        this.buildings.get(building.getClass()).remove(building);
        this.algoCraftMap.clearTile(building.getPosition());
    }

    public void removeBuildingInConstruction(BuildingInConstruction building){
        this.buildingsInConstruction.remove(building);
        this.algoCraftMap.clearTile(building.getPosition());
    }

    public void removeUnit(Unit unit){
        this.units.remove(unit);
        this.algoCraftMap.clearTile(unit.getPosition());
    }

    public void canTrain(Unit unitToBeTrained) throws InsufficientResourcesException, InsufficientAvailablePopulationException {
        this.verifyCost(unitToBeTrained.getTrainingCost());
        this.verifyPopulationAvailability(unitToBeTrained.getUnitSize());
    }

    private void verifyPopulationAvailability(int unitSize) throws InsufficientAvailablePopulationException{
        if (this.population.getAvailablePopulation() < unitSize + this.population.getUsedPopulation()) throw new InsufficientAvailablePopulationException();
    }

    public void subtractResources(Cost unitCost) throws SubtractedResourcesGreaterThanStoragedException {
        this.resources.subtractResources(unitCost);
    }

    public void chargeUnitRequirements(Unit unit)
            throws InsufficientAvailablePopulationException, InsufficientResourcesException,
            SubtractedResourcesGreaterThanStoragedException {
        this.canTrain(unit);
        this.subtractResources(unit.getTrainingCost());
        this.addUsedPopulation(unit.getUnitSize());
    }

    public AlgoCraftMap getAlgoCraftMap(){
        return this.algoCraftMap;
    }
}
