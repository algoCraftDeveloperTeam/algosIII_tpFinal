package fiuba.algo3.view.map;

import fiuba.algo3.model.map.AlgoCraftMap;
import fiuba.algo3.model.map.Coordinates;
import fiuba.algo3.model.map.Earth;
import fiuba.algo3.model.map.Gas;
import fiuba.algo3.model.map.Mineral;
import fiuba.algo3.model.map.Space;
import fiuba.algo3.model.map.Tile;
import fiuba.algo3.model.occupant.units.Unit;
import fiuba.algo3.model.occupant.units.CombatUnit;
import fiuba.algo3.view.sideMenu.ActionButton;
import fiuba.algo3.view.sideMenu.InfoArea;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;
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

	public MapView(int x, int y, int width, int height, AlgoCraftMap modelMap, List<ActionButton> buttons, InfoArea infoArea)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		setBounds(x, y, width, height);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		dimention = modelMap.getDimention();
		setLayout(new GridLayout(dimention, dimention));
        algoCraftMap = modelMap;
        tiles = new ArrayList<TileView>();
        generateTileViews();
        generateMapView(buttons, infoArea);
	}

    private void generateMapView(List<ActionButton> buttons, InfoArea infoArea)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (int i = 0; i < dimention; i++){
            for (int j = 0; j < dimention; j++){
                Coordinates actualPosition = new Coordinates(j, i);
                Tile actualTile = algoCraftMap.getTile(actualPosition);
                Class<?> viewClass = tileGenerator.get(actualTile.getClass());
                TileView tileView = (TileView) viewClass.newInstance();
                tileView.setModelTile(actualTile);
                tileView.setObservers(buttons, infoArea);
                tileView.setMap(this);
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

    public void setMoveBehavior(Unit occupant){
        for(TileView tile : tiles){
            tile.setMoveBehavior(occupant);
        }
    }

    public void setAttackBehavior(CombatUnit occupant){
        for(TileView tile : tiles){
            tile.setAttackBehavior(occupant);
        }
    }

    public AlgoCraftMap getModelMap(){
        return algoCraftMap;
    }
}