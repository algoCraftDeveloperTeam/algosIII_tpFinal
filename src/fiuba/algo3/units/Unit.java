package fiuba.algo3.units;

/**
 * Created by mporto on 28/05/15.
 */
public abstract class Unit {

    int size_for_transport;
    int field_of_vision;
    // TO DO: add cost atribute.
    int construction_time;
    // TO DO: add damage atribute.
    int unit_size;
    // TO DO: add attack_range.
    int life;

    public int getLife() {

        return life;
    }

    public int getSizeForTransport() {
        
        return size_for_transport;
    }
}
