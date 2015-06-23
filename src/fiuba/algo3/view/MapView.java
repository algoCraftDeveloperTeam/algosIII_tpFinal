package fiuba.algo3.view;

import fiuba.algo3.map.AlgoCraftMap;
import fiuba.algo3.map.Coordinates;
import fiuba.algo3.map.Earth;
import fiuba.algo3.map.Gas;
import fiuba.algo3.map.Mineral;
import fiuba.algo3.map.Space;
import fiuba.algo3.map.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MapView extends JPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    HashMap<Class<?>, Class<?>> tileGenerator;
    AlgoCraftMap algoCraftMap;
    private int dimention;

	public MapView(int x, int y, int width, int height, AlgoCraftMap algoCraftMap)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		addMouseListener(this);
		setBounds(x, y, width, height);
		setBackground(Color.YELLOW);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(algoCraftMap.getDimention(), algoCraftMap.getDimention()));
        this.algoCraftMap = algoCraftMap;
		this.dimention = algoCraftMap.getDimention();
        this.generateTileViews();
        this.generateMapView();

		/*for (int i = 0; i < (this.dimention * this.dimention); i++){
			JPanel panel = new JPanel();
			if (i % 3 == 0){
				panel.setBackground(Color.RED);
			} else if(i % 3 == 1){
				panel.setBackground(Color.BLUE);		******EJEMPLO PARA VISUALIZAR******
			} else{
				panel.setBackground(Color.GREEN);
			}
			add(panel);
		}*/
	}

    private void generateMapView()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++){
                Coordinates actualPosition = new Coordinates(j, i);
                Tile actualTile = algoCraftMap.getTile(actualPosition);
                Class<?> viewClass = tileGenerator.get(actualTile.getClass());
                TileView tileView = (TileView) viewClass.newInstance();
                add(tileView);
            }
        }
    }

    private void generateTileViews() {
        // Con la clase del tile del modelo, usamos la clase correspondiente de
        // tileView para crear un tileView
		tileGenerator = new HashMap<Class<?>, Class<?>>();
		tileGenerator.put(Earth.class, EarthTileView.class);
		tileGenerator.put(Mineral.class, MineralTileView.class);
		tileGenerator.put(Gas.class, GasTileView.class);
		tileGenerator.put(Space.class, SpaceTileView.class);
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