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
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private HashMap<Class<?>, Class<?>> tileGenerator;
    private AlgoCraftMap algoCraftMap;
    private List<TileView> tiles;
    private int dimention;

	public MapView(int x, int y, int width, int height, AlgoCraftMap modelMap, List<ActionButton> buttons)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		setBounds(x, y, width, height);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		dimention = modelMap.getDimention();
		setLayout(new GridLayout(dimention, dimention));
        algoCraftMap = modelMap;
        tiles = new ArrayList<TileView>();
        generateTileViews();
        generateMapView(buttons);
	}

    private void generateMapView(List<ActionButton> buttons)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++){
                Coordinates actualPosition = new Coordinates(j, i);
                Tile actualTile = algoCraftMap.getTile(actualPosition);
                Class<?> viewClass = tileGenerator.get(actualTile.getClass());
                TileView tileView = (TileView) viewClass.newInstance();
                tileView.setModelTile(actualTile);
                tileView.setObservers(buttons);
                tiles.add(tileView);
                add(tileView);
            }
        }
    }

    private void generateTileViews() {
		tileGenerator = new HashMap<Class<?>, Class<?>>();
		tileGenerator.put(Earth.class, EarthTileView.class);
		tileGenerator.put(Mineral.class, MineralTileView.class);
		tileGenerator.put(Gas.class, GasTileView.class);
		tileGenerator.put(Space.class, SpaceTileView.class);
    }

    public void refreshTiles(){
        for(TileView tile : tiles){
            tile.refreshOccupant();
        }
    }
}