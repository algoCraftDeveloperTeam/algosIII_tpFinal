package fiuba.algo3.view.map;

import fiuba.algo3.view.map.TileView;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

/**
 * Created by mporto on 22/06/15.
 */
public class MineralTileView extends TileView implements MouseListener{

    public MineralTileView() {
		addMouseListener(this);
		setBackground(Color.BLUE);
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
	}
}
