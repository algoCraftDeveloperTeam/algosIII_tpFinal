package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import fiuba.algo3.game.AlgoCraftModel;

public class SideMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<ActionButton> actionButtons;
	List<PlayerData> playerData;
	PassTurnButton passTurnButton;

	public SideMenu(int x, int y, int width, int height, AlgoCraftModel algoCraftModel) {
		setBounds(x, y, width, height);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(20, 2));
		actionButtons = new ArrayList<ActionButton>();
		playerData = new ArrayList<PlayerData>();
		createAndAddButtons(algoCraftModel);
		createAndAddLabels(algoCraftModel);
		passTurnButton = new PassTurnButton(algoCraftModel, playerData);
		add(passTurnButton);
	}

	private void createAndAddButtons(AlgoCraftModel algoCraftModel){
		ActionButton moveButton = new MoveButton(algoCraftModel);
		ActionButton attackButton = new AttackButton(algoCraftModel);
		ActionButton buildButton = new BuildButton(algoCraftModel);
		ActionButton createUnitButton = new CreateUnitButton(algoCraftModel);
		actionButtons.add(moveButton);
		actionButtons.add(attackButton);
		actionButtons.add(buildButton);
		actionButtons.add(createUnitButton);
		add(moveButton);
		add(attackButton);
		add(buildButton);
		add(createUnitButton);
	}

	private void createAndAddLabels(AlgoCraftModel algoCraftModel){
		PlayerData actualPlayerName = new PlayerName(algoCraftModel);
		PlayerData actualPlayerGas = new PlayerGas(algoCraftModel);
		PlayerData actualPlayerMineral = new PlayerMineral(algoCraftModel);
		playerData.add(actualPlayerName);
		playerData.add(actualPlayerGas);
		playerData.add(actualPlayerMineral);
		add(actualPlayerName);
		add(actualPlayerGas);
		add(actualPlayerMineral);
	}

	public void setMap(MapView map){
		for(ActionButton actionButton : actionButtons){
            actionButton.setMap(map);
        }
        passTurnButton.setMap(map);
	}

	public List<ActionButton> getActionButtons(){
		return actionButtons;
	}

}