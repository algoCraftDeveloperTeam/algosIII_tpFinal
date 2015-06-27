package fiuba.algo3.view;

import fiuba.algo3.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by mporto on 22/06/15.
 */
public abstract class TileView extends JComponent{

	protected Tile modelTile;
	protected List<ActionButton> observers;

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
	}

	public void setModelTile(Tile tile){
		modelTile = tile;
	}

	public void setObservers(List<ActionButton> buttons){
		observers = buttons;
	}

	public abstract void refreshOccupant();
}
