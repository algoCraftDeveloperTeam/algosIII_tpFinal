package fiuba.algo3.view;

import java.awt.*;

/**
 * Created by mporto on 22/06/15.
 */
public class EarthTileView extends TileView{

    public EarthTileView() {
        this.color = "brown";
    }

    public Color getTileColor(){
        return Color.getColor(this.color);
    }
}
