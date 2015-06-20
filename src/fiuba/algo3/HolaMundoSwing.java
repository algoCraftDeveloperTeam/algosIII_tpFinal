package fiuba.algo3;

import javax.swing.JLabel;
import javax.swing.JFrame;

public class HolaMundoSwing extends JFrame{
	
	private JLabel texto1;

	public HolaMundoSwing() {
		setLayout(null);
		texto1=new JLabel("Nacho y Manu putos :D");
		texto1.setBounds(100,100,200,40);
		add(texto1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}