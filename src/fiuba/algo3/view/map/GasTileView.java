package fiuba.algo3.view.map;

import fiuba.algo3.view.map.TileView;
import fiuba.algo3.model.occupant.Occupant;
import fiuba.algo3.model.exceptions.*;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

/**
 * Created by mporto on 22/06/15.
 */
public class GasTileView extends TileView implements MouseListener{

    public GasTileView() {
		addMouseListener(this);
		setBackground(Color.GREEN);
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
		try{
			Occupant o = modelTile.getOccupant();
			String path = String.valueOf(o.getClass());
			String[] parts = path.split("[.]");
			Method m = MegaDrawer.class.getDeclaredMethod("get"+parts[parts.length - 1]+"Drawer");
			occupantDrawer = (OccupantDrawer) m.invoke(MegaDrawer.getInstance());
		} catch (EmptyTileException ex){
			occupantDrawer = EmptyDrawer.getInstance();
		} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex){
			System.out.println("ups");
		}
		repaint();
	}
}
