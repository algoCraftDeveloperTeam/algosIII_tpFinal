package fiuba.algo3.view.map;

import fiuba.algo3.view.map.TileView;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

/**
 * Created by mporto on 22/06/15.
 */
public class EarthTileView extends TileView implements MouseListener{

    public EarthTileView() {
		addMouseListener(this);
		setBackground(Color.RED);
		try{
			method = TileView.class.getDeclaredMethod("defaultBehavior");
		} catch(NoSuchMethodException ex){
			ex.printStackTrace();
		}
		occupantDrawer = EmptyDrawer.getInstance();
    }

    @Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try{
			method.invoke(this);
		} catch (IllegalAccessException | InvocationTargetException ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void refreshOccupant(){
		try{
			method = TileView.class.getDeclaredMethod("defaultBehavior");
		} catch(NoSuchMethodException ex){
			ex.printStackTrace();
		}
		if(modelTile.isOccupied()){
			occupantDrawer = OccupiedDrawer.getInstance();
		} else{
			occupantDrawer = EmptyDrawer.getInstance();
		}
	}
}
