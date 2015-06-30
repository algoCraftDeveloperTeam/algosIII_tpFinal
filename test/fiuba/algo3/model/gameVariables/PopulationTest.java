package fiuba.algo3.model.gameVariables;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mporto on 31/05/15.
 */
public class PopulationTest {

    private Population aPopulation;

    @Before
    public void setUp() throws Exception {
        aPopulation = new Population();
    }

    @Test
    public void testInitialAvailablePopulationItsZero() throws Exception {
        assertEquals(0, aPopulation.getAvailablePopulation());
    }

    @Test
    public void testInitialUsedPopulationItsZero() throws Exception {
        assertEquals(0, aPopulation.getUsedPopulation());
    }

    @Test
    public void testAddAvailablePopulationAddsTheQuantityDesired() throws Exception {
        aPopulation.addAvailablePopulation(5);

        assertEquals(5, aPopulation.getAvailablePopulation());
    }

    @Test
    public void testAddAvailablePopulationCannotExceedThePopulationCap() throws Exception {
        // When it reaches the population cap the method stops adding available
        // population.

        aPopulation.addAvailablePopulation(201);

        assertEquals(200, aPopulation.getAvailablePopulation());
    }
}