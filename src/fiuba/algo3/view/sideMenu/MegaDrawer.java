package fiuba.algo3.view.map;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;

public class MegaDrawer {

	private static MegaDrawer instance = null; 

	private MegaDrawer(){}

	public static MegaDrawer getInstance(){
		if(instance == null){
			instance = new MegaDrawer();
		}
		return instance;
	}

	public OccupantDrawer getEmptyDrawer(){
		return EmptyDrawer.getInstance();
	}

	public OccupantDrawer getBarracksDrawer(){
		return BarracksDrawer.getInstance();
	}

}
