package fiuba.algo3.model.game;

import fiuba.algo3.model.exceptions.*;
import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.occupant.buildings.Building;
import fiuba.algo3.model.player.Player;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by montag on 6/17/15.
 */
public class AlgoCraftModel implements TurnAware{

    private Queue<Player> players;
    private AlgoCraftMap algoCraftMap;
    private Player activePlayer;

    public AlgoCraftModel(){
        players = new LinkedList<>();
        algoCraftMap = new AlgoCraftMap(10);
        int numberOfPlayers = 2;
        for (int i = 0; i < numberOfPlayers; i++) players.add(new Player(algoCraftMap,"Player " + String.valueOf(i+1)));
        activePlayer = players.remove();
    }

    @Override
    public void passTurn() {
        activePlayer.passTurn();
    }

    public void build(Building building) throws InsufficientResourcesException, CannotOccupyTileException, MissingRequiredBuildingsException, DestinationIsOccupiedException, KeyDoesNotExistsException {
        activePlayer.build(building);
    }

    public void endTurn(){
        players.add(activePlayer);
        activePlayer = players.remove();
        this.passTurn();
    }

    public Player getActivePlayer(){
        return activePlayer;
    }

    public AlgoCraftMap getAlgoCraftMap() {
        return this.algoCraftMap;
    }
}
