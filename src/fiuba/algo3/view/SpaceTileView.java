package fiuba.algo3.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.reflect.*;

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
    }

    @Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
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
			setBackground(Color.ORANGE);
		} else{
			setBackground(Color.BLACK);
		}
	}
}
