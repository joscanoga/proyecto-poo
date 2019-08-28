package view;
import javax.imageio.ImageIO;
import javax.swing.*;

import excepciones.ErrorLogin;
import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.usuarios.UsuarioInvitado;
//import uiMain.Main;
import greenBank.GreenBank;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
public class VentanaAdministrador extends JFrame{
	public static Container panel;
	public static JMenuBar barraMenu = new JMenuBar();
	public VentanaAdministrador() {
		super("Usuario: "+GreenBank.getUsuario().getNombreUsuario());
		panel=this.getContentPane();
		panel.setLayout(new BorderLayout());
		JMenu archivo=new JMenu("archivo");
		archivo.setPreferredSize(new Dimension(150, 20));
		JMenuItem aUsuario = new JMenuItem("Usuario");
		archivo.add(aUsuario);
		JMenuItem aSalir=new JMenuItem("Salir");
		archivo.add(aSalir);
		JMenu procesosYConsultas =new JMenu("Procesos y Consultas");
		JMenuItem ayuda =new JMenuItem("Ayuda");

		barraMenu.add(archivo);
		barraMenu.add(procesosYConsultas);
		barraMenu.add(ayuda);
		panel.add(barraMenu,BorderLayout.NORTH);
		setLocation(400, 100);
        setSize(700, 400);
        setVisible(true);
	}
}
