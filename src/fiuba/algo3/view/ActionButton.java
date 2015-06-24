package fiuba.algo3.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public abstract class ActionButton extends JButton{

	public ActionButton() {

	}

	public void build(){
		setEnabled(false);
	}
}