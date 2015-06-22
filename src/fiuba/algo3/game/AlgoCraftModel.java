package fiuba.algo3.game;

import fiuba.algo3.exceptions.*;
import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.occupant.buildings.Building;
import fiuba.algo3.player.Player;

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
        algoCraftMap = new AlgoCraftMap(5);
        int numberOfPlayers = 2;
        for (int i = 0; i < numberOfPlayers; i++) players.add(new Player(algoCraftMap));
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
