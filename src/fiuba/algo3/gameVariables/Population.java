package fiuba.algo3.gameVariables;

/**
 * Created by mporto on 31/05/15.
 */
public class Population {


    private static int populationCap = 200;
    private int usedPopulation = 0;
    private int availablePopulation = 0;

    public static int getPopulationCap() {
        return populationCap;
    }
    public int getAvailablePopulation() {
        return availablePopulation;
    }

    public void addAvailablePopulation(int i) {
        if(Population.getPopulationCap() > (this.availablePopulation + i)){
            this.availablePopulation += i;
        }else{
            this.availablePopulation = 200;
        }
    }

    public int getUsedPopulation() {
        return usedPopulation;
    }
}
