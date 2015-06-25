package fiuba.algo3.map;

import fiuba.algo3.exceptions.CannotOccupyTileException;
import fiuba.algo3.exceptions.EmptyTileException;
import fiuba.algo3.exceptions.KeyDoesNotExistsException;
import fiuba.algo3.occupant.Occupant;
import fiuba.algo3.occupant.units.Unit;

import java.util.HashMap;
import java.util.Map;

public class AlgoCraftMap{

	private Map<Coordinates,Tile> tiles;
	private int dimention;

	public AlgoCraftMap(int dim){
		tiles = new HashMap<Coordinates,Tile>();
		dimention = dim;
		generateEarth();
		//generateSpace();
		generateMineralAndGas();
	}

	private void generateEarth(){
		Tile earth;
		for(int i = 0; i < dimention; i++){
			for(int j = 0; j < dimention; j++){
				Coordinates coord = new Coordinates(i,j);
				earth = new Earth(coord);
				tiles.put(coord,earth);
			}
		}
	}

	private void generateMineralAndGas(){
		Tile mineral;
		Tile gas;
		Coordinates coord1 = new Coordinates(1,2);
		Coordinates coord2 = new Coordinates(2,1);
		Coordinates coord3 = new Coordinates(dimention-2,dimention-3);
		Coordinates coord4 = new Coordinates(dimention-3,dimention-2);
		mineral = new Mineral(coord1);
		tiles.put(coord1,mineral);
		gas = new Gas(coord2);
		tiles.put(coord2,gas);
		gas = new Gas(coord3);
		tiles.put(coord3,gas);
		mineral = new Mineral(coord4);
		tiles.put(coord4,mineral);
	}

	public AlgoCraftMap testMap(){
		tiles.clear();
		dimention = 20;
		Tile earth;
		Tile mineral;
		Tile gas;
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++){
				Coordinates coord = new Coordinates(i,j);
				earth = new Earth(coord);
				tiles.put(coord,earth);
			}
		}
		Coordinates coord1 = new Coordinates(19,19);
		Coordinates coord2 = new Coordinates(18,19);
		mineral = new Mineral(coord1);
		tiles.put(coord1,mineral);
		gas = new Gas(coord2);
		tiles.put(coord2,gas);
		return this;
	}

	public void put(Occupant occupant, Coordinates coord) throws CannotOccupyTileException, KeyDoesNotExistsException{
		if (tiles.containsKey(coord)){
			Tile tile = tiles.get(coord);
			tile.put(occupant);
		} else {
			throw new KeyDoesNotExistsException();
		}
	}

	public void locate(Unit unit, Coordinates coord){
		boolean located = false;
		int coordX = coord.getX();
		int coordY = coord.getY();
		int dim = 1;
		while(!located){
			int i = -dim;
			while(i <= dim && !located){
				int j = -dim;
				while(j <= dim && !located){
					try{
						located = true;
						Coordinates destination = new Coordinates(coordX+j, coordY+i);
						unit.setPosition(this, destination);
					} catch(KeyDoesNotExistsException | CannotOccupyTileException ex){
						located = false;
					}
					j++;
				}
				i++;
			}
			dim++;
		}
	}

	public void clearTile (Coordinates coord){
		Tile current = tiles.get(coord);
		current.clear();
	}

	public void move(Coordinates origin, Coordinates destination) throws EmptyTileException, CannotOccupyTileException,
			KeyDoesNotExistsException{
		Occupant current = tiles.get(origin).getOccupant();
		put(current, destination);
		clearTile(origin);
	}

	public boolean isOccupied(Coordinates coord){
		return tiles.get(coord).isOccupied();
	}

	public Occupant getOccupant(Coordinates coordinate) throws EmptyTileException{
		try {
			return tiles.get(coordinate).getOccupant();
		} catch (EmptyTileException ex) {
			return null;
		}
	}

	public Tile getTile(Coordinates coordinate) {
        return tiles.get(coordinate);
    }

    public int getDimention() {
        return dimention;
    }
}
