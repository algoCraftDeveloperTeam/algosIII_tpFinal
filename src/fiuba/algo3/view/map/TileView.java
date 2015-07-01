package fiuba.algo3.view.map;

import fiuba.algo3.model.exceptions.EmptyTileException;
import fiuba.algo3.model.exceptions.InvalidMovementException;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.occupant.Damageable;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.occupant.units.CombatUnit;
import fiuba.algo3.model.occupant.units.Unit;
import fiuba.algo3.view.ErrorMessages;
import fiuba.algo3.view.map.drawers.OccupantDrawer;
import fiuba.algo3.view.sideMenu.ActionButton;
import fiuba.algo3.view.sideMenu.InfoArea;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by mporto on 22/06/15.
 */
public abstract class TileView extends JComponent implements MouseListener{

	protected Tile modelTile;
	protected MapView mapView;
	protected List<ActionButton> observers;
	protected Method method;
	protected Unit unit;
	protected CombatUnit combatUnit;
	protected InfoArea infoArea;
	protected OccupantDrawer occupantDrawer;

	@Override
	public void paintComponent(Graphics g){
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		occupantDrawer.paintComponent(g, (int) getWidth(), (int) getHeight());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		try{
			Occupant o = modelTile.getOccupant();
			infoArea.setInfo(o.getInfo());
		} catch(EmptyTileException ex){
			infoArea.setInfo(modelTile.getInfo());
		}
		setBorder(new BorderUIResource.LineBorderUIResource(Color.PINK, 2));
	}

	@Override
	public void mouseExited(MouseEvent e) {
        infoArea.setInfo("info.life.shield");
		setBorder(null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		setBorder(new BorderUIResource.LineBorderUIResource(Color.PINK, 4));
	}


	public void setModelTile(Tile tile){
		modelTile = tile;
	}

	public void setObservers(List<ActionButton> buttons, InfoArea iArea){
		observers = buttons;
		infoArea = iArea;
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
		unit = newOccupant;
	}

	public void setAttackBehavior(CombatUnit newOccupant){
		try{
			method = TileView.class.getDeclaredMethod("attackBehavior");
		} catch(NoSuchMethodException ex){
			ex.printStackTrace();
		}
		combatUnit = newOccupant;
	}

	public void moveBehavior(){
		try{
			unit.move(mapView.getModelMap(), modelTile.getPosition());
			mapView.refreshTiles();
		} catch(InvalidMovementException ex){
			ErrorMessages.sendMessage(ex.getMessage());
		}
	}

	public void attackBehavior(){
		try{
			if(combatUnit.getOwner() != modelTile.getOccupant().getOwner()){
				combatUnit.attack((Damageable) modelTile.getOccupant());
				mapView.refreshTiles();
			} else{
				ErrorMessages.sendMessage("You can not attack your own units/buildings");
			}
		} catch(EmptyTileException ex){
			ErrorMessages.sendMessage(ex.getMessage());
		}
	}
}
