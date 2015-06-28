package fiuba.algo3.view;

import fiuba.algo3.map.Tile;
import fiuba.algo3.occupant.units.Unit;
import fiuba.algo3.exceptions.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.lang.reflect.*;

/**
 * Created by mporto on 22/06/15.
 */
public abstract class TileView extends JComponent{

	protected Tile modelTile;
	protected MapView mapView;
	protected List<ActionButton> observers;
	protected Method method;
	protected Unit occupant;

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(Color.BLACK);
		g.fillOval(0,0,getWidth(),getHeight());
	}

	public void setModelTile(Tile tile){
		modelTile = tile;
	}

	public void setObservers(List<ActionButton> buttons){
		observers = buttons;
	}

	public void setMap(MapView map){
		mapView = map;
	}

	public abstract void refreshOccupant();

	public void defaultBehavior(){
		for(ActionButton observer : observers){
			observer.setBehavior(modelTile, this);
		}
	}

	public void setMoveBehavior(Unit newOccupant){
		try{
			method = TileView.class.getDeclaredMethod("moveBehavior");
		} catch(NoSuchMethodException ex){
			ex.printStackTrace();
		}
		occupant = newOccupant;
	}

	public void moveBehavior(){
		try{
			occupant.move(mapView.getModelMap(), modelTile.getPosition());
			mapView.refreshTiles();
		} catch(InvalidMovementException ex){
			System.out.println("no podes moverte ahi gil");
		}
	}
}
