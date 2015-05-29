package fiuba.algo3.units;

/**
 * Created by mporto on 28/05/15.
 */
public class Marine extends Unit{

    public Marine() {
        size_for_transport = 1;
        field_of_vision = 7;
        construction_time = 3;
        unit_size = 1;
        life = 40;
        for(int i = 0; i < 2; i++){}
    }

}
