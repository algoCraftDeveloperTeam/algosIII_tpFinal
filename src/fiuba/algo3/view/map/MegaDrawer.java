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

	public OccupantDrawer getSupplyDepotDrawer(){
		return SupplyDepotDrawer.getInstance();
	}

	public OccupantDrawer getBuildingInConstructionDrawer(){
		return BuildingInConstructionDrawer.getInstance();
	}

	public OccupantDrawer getMineralCenterDrawer(){
		return MineralCenterDrawer.getInstance();
	}

	public OccupantDrawer getRefineryDrawer(){
		return RefineryDrawer.getInstance();
	}

	public OccupantDrawer getStarPortDrawer(){
		return StarPortDrawer.getInstance();
	}

	public OccupantDrawer getTerranFactoryDrawer(){
		return TerranFactoryDrawer.getInstance();
	}

	public OccupantDrawer getMarineDrawer(){
		return MarineDrawer.getInstance();
	}

	public OccupantDrawer getGoliathDrawer(){
		return GoliathDrawer.getInstance();
	}

	public OccupantDrawer getTerranTransportVesselDrawer(){
		return TerranTransportVesselDrawer.getInstance();
	}

}