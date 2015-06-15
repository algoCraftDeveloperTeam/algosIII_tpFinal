package fiuba.algo3.occupant.buildings;

import fiuba.algo3.gameVariables.Cost;
import fiuba.algo3.gameVariables.Life;
import fiuba.algo3.player.Player;
import fiuba.algo3.occupant.units.UnitInTraining;
import fiuba.algo3.occupant.units.Zealot;

import java.util.LinkedList;
import java.util.Queue;

public class Access extends Building implements UnitCreator{

    private Queue<UnitInTraining> trainingQueue;

    public Access(Player player, int coordX, int coordY) {
    	super(player, coordX, coordY);
        this.constructionCost = new Cost(150, 0);
        this.constructionTime = 8;
        this.life = new Life(500, 500);
        this.trainingQueue = new LinkedList<UnitInTraining>();
    }

    @Override
    public void trainUnit(){
        Zealot aZealotToBeTrained = new Zealot();
        UnitInTraining aZealotInTraining = new UnitInTraining(aZealotToBeTrained);
        this.trainingQueue.add(aZealotInTraining);
    }

    @Override
    public void passTurn() {
        super.passTurn();
        UnitInTraining firstUnit = this.trainingQueue.peek();
        firstUnit.passTurn();
    }
}