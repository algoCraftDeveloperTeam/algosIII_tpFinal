package fiuba.algo3.resources;
import fiuba.algo3.player.Player;
/**
 * Created by nsueiro on 28/05/15.
 */
public interface Resource {
    public void addResources(Player player);

    public int getQuantity();
}
