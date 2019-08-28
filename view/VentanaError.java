package view;
import javax.swing.*;
import java.awt.*;

public class VentanaError extends JFrame  {
	Container panel;
	public VentanaError(String text) {
		super("Error");
		panel=this.getContentPane();
		panel.setLayout(new BorderLayout());
		panel.add(new JTextField(text), BorderLayout.CENTER);
		setSize(300,100);
		setVisible(true);
		setLocation(400, 100);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
//	 

}
