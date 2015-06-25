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

	public SideMenu(int x, int y, int width, int height, AlgoCraftModel algoCraftModel) {
		setBounds(x, y, width, height);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setLayout(new GridLayout(20, 2));
		actionButtons = new ArrayList<ActionButton>();
		MoveButton moveButton = new MoveButton(algoCraftModel);
		AttackButton attackButton = new AttackButton(algoCraftModel);
		BuildButton buildButton = new BuildButton(algoCraftModel);
		CreateUnitButton createUnitButton = new CreateUnitButton(algoCraftModel);
		add(moveButton);
		add(attackButton);
		add(buildButton);
		add(createUnitButton);
		actionButtons.add(moveButton);
		actionButtons.add(attackButton);
		actionButtons.add(buildButton);
		actionButtons.add(createUnitButton);
	}

	public List<ActionButton> getActionButtons(){
		return actionButtons;
	}

}