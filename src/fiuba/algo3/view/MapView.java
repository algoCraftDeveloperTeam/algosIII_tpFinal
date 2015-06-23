package fiuba.algo3.view;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.map.Earth;
import fiuba.algo3.map.Tile;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class MapView extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    HashMap<Class<?>, TileView> tileViews;
    HashMap<Coordinates, Color> algoCraftMapView;
    AlgoCraftMap algoCraftMap;

	public MapView(int x, int y, int width, int height, AlgoCraftMap algoCraftMap) {
		setBounds(x, y, width, height);
		setBackground(Color.YELLOW);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		addMouseListener(this);
		Border etched = new EtchedBorder();
		setBorder(etched);
		setBackground(Color.yellow);
		setSize(width, height);
        this.algoCraftMap = algoCraftMap;
        
        // algoCraftMapView initialization.
        this.generateTileViews();
        this.generateAlgoCraftMapView();
	}

    private void generateAlgoCraftMapView() {
        int dimention = algoCraftMap.getDimention();
        algoCraftMapView = new HashMap<>();

        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++){
                Coordinates actualPosition = new Coordinates(i, j);
                Tile actualTile = algoCraftMap.getTile(actualPosition);
                algoCraftMapView.put(actualPosition, tileViews.get(actualTile.getClass()).getTileColor());
            }
        }
    }

    private void generateTileViews() {
        tileViews = new HashMap<>();
        tileViews.put(Earth.class, new EarthTileView());
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}
}