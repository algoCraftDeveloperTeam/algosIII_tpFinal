package fiuba.algo3.map;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class AlgoCraftMap{

	private Map<Coordinates,Tile> tiles;
	private int dimention;
	private int posXPlayer1;
	private int posYPlayer1;
	private int posXPlayer2;
	private int posYPlayer2;

	public AlgoCraftMap(int dim){
		tiles = new HashMap<Coordinates,Tile>();
		dimention = dim;
		generateEarthAndSpace();
		/*placeBases();
		placeMineralAndGas(posXPlayer1, posYPlayer1);
		placeMineralAndGas(posXPlayer2, posYPlayer2);
		*///showMap();
	}

	private void generateEarthAndSpace(){
		Tile earth;
		for(int i = 0; i < dimention; i++){
			for(int j = 0; j < dimention; j++){
				Coordinates coord = new Coordinates(i,j);
				earth = new Earth();
				tiles.put(coord,earth);
			}
		}
	}

	/*private void placeBases(){
		Random random = new Random();
		int randomRow = random.nextInt(dimention);
		int randomCol;
		if(randomRow < (dimention / 4) || randomRow >= (dimention * 3 / 4)){
			randomCol = random.nextInt(dimention);
		} else{
			randomCol = random.nextInt(dimention / 2);
			if(randomCol >= (dimention / 4)){
				randomCol += dimention / 2;
			}
		}
		posXPlayer1 = randomCol;
		posYPlayer1 = randomRow;
		posXPlayer2 = dimention - randomCol - 1;
		posYPlayer2 = dimention - randomRow - 1;
	}

	private void placeMineralAndGas(int posX, int posY){
		Random rand = new Random();
		int randColGas = -dimention;
		int randRowGas = -dimention;
		int randColMineral = -dimention;
		int randRowMineral = -dimention;
		while(isNotValid(posX, randColGas, posY, randRowGas)){
			randColGas = rand.nextInt(5) - 2;
			randRowGas = rand.nextInt(5) - 2;
		}
		while(isNotValid(posX, randColMineral, posY, randRowMineral) ||
				isOverGas(randColMineral, randColGas, randRowMineral, randRowGas)){
			randColMineral = rand.nextInt(5) - 2;
			randRowMineral = rand.nextInt(5) - 2;
		}
		Coordinates gasCoord = new Coordinates(posX + randColGas, posY + randRowGas);
		Coordinates mineralCoord = new Coordinates(posX + randColMineral, posY + randRowMineral);
		Tile gas = new Gas();
		Tile mineral = new Mineral();
		tiles.put(gasCoord,gas);
		tiles.put(mineralCoord,mineral);
	}

	private boolean isNotValid(int x, int offsetX, int y, int offsetY){
		return ((x+offsetX < 0) ||
				(x+offsetX >= dimention) ||
				(y+offsetY < 0) ||
				(y+offsetY >= dimention) ||
				(offsetX == 0 && offsetY == 0));
	}

	private boolean isOverGas(int x1, int x2, int y1, int y2){
		return ((x1 == x2) && (y1 == y2));
	}*/

/*	private void showMap(){
		for(int i = 0; i < dimention; i++){
			String line = "";
			for(int j = 0; j < dimention; j++){
				line += writeTile(j,i);
			}
			System.out.println(line);
		}
	}

	private boolean isBase(int col, int row){
		return ((posXPlayer1 == col && posYPlayer1 == row) || (posXPlayer2 == col && posYPlayer2 == row));
	}

	private String writeTile(int col, int row){
		if (isBase(col,row)){
			return "o";
		} else if (tiles[col][row] instanceof Earth){
			return ".";
		} else{
			return "*";
		}
	}
*/
}
