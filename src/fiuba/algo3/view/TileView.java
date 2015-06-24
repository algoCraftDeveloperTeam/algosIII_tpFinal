package fiuba.algo3.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import fiuba.algo3.map.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mporto on 22/06/15.
 */
public abstract class TileView extends JPanel{

	protected Tile modelTile;
	protected List<ActionButton> observers;

	public void setModelTile(Tile tile){
		modelTile = tile;
	}

	public void setObservers(List<ActionButton> buttons){
		observers = buttons;
	}
}
