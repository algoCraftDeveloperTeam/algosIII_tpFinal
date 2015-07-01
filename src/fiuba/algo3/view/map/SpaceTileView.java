package fiuba.algo3.view.map;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by mporto on 22/06/15.
 */
public class SpaceTileView extends TileView implements MouseListener{

    public SpaceTileView() {
		addMouseListener(this);
		setBackground(Color.BLACK);
		try{
			method = TileView.class.getDeclaredMethod("defaultBehavior");
		} catch(NoSuchMethodException ex){
			ex.printStackTrace();
		}
		occupantDrawer = EmptyDrawer.getInstance();
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
