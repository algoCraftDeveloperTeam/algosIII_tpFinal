package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class BuildButton extends ActionButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuildButton() {
		setText("Build");
		setVisible(true);
	}

	public void build(){
		setEnabled(true);
	}
}