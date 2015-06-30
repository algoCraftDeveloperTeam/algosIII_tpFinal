package fiuba.algo3.view;

import fiuba.algo3.model.game.AlgoCraftModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
		createLabels(algoCraftModel);
		createButtons(algoCraftModel);
		addButtonsAndLabels();
	}

	private void createButtons(AlgoCraftModel algoCraftModel){
		ActionButton moveButton = new MoveButton(algoCraftModel);
		ActionButton attackButton = new AttackButton(algoCraftModel);
		ActionButton buildButton = new BuildButton(algoCraftModel, playerData);
		ActionButton createUnitButton = new CreateUnitButton(algoCraftModel, playerData);
		actionButtons.add(moveButton);
		actionButtons.add(attackButton);
		actionButtons.add(buildButton);
		actionButtons.add(createUnitButton);
		passTurnButton = new PassTurnButton(algoCraftModel, playerData, actionButtons);
	}

	private void createLabels(AlgoCraftModel algoCraftModel){
		PlayerData actualPlayerName = new PlayerName(algoCraftModel);
		PlayerData actualPlayerGas = new PlayerGas(algoCraftModel);
		PlayerData actualPlayerMineral = new PlayerMineral(algoCraftModel);
		PlayerData actualPlayerPopulation = new PlayerPopulation(algoCraftModel);
		playerData.add(actualPlayerName);
		playerData.add(actualPlayerGas);
		playerData.add(actualPlayerMineral);
		playerData.add(actualPlayerPopulation);
	}

	private void addButtonsAndLabels(){
		for(ActionButton button : actionButtons){
			add(button);
		}
		for(PlayerData label : playerData){
			add(label);
		}
		add(passTurnButton);
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

	public List<PlayerData> getPlayerData(){
		return playerData;
	}

}