package fiuba.algo3.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;

/**
 * Created by mporto on 22/06/15.
 */
public abstract class TileView extends JPanel{

	protected Tile modelTile;

	public void setModelTile(Tile tile){
		modelTile = tile;
	}
}
