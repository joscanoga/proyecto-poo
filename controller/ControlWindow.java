package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import excepciones.ErrorLogin;
import gestionAplicacion.usuarios.UsuarioInvitado;
import view.VentanaError;
import view.Window;

public class ControlWindow {
	JButton imagesButton, adminButton, userButton, exitButton,loginButton;
	String[] imageSources = {"text.png", "logo.png", "money.png"};
	private byte imageIndex = Window.getimageIndex();
	String activeUser = "";

	 public void actionPerformed(ActionEvent e) {
	       
			if (e.getSource().equals(imagesButton)) {

	            imageIndex += (imageIndex == 2 ? -2 : 1);
	            Image img = null;
	            try {
	                img = ImageIO.read(getClass().getResource(imageSources[imageIndex]));
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	            imagesButton.setIcon(new ImageIcon(img));
	        } else if(e.getSource().equals(userButton) || e.getSource().equals(adminButton)) {
//	        	VentanaError ventana =new VentanaError("Usuario o cleve incorecta");
	            if (!activeUser.equals("")) {
	                (activeUser.equals("admin") ? adminButton : userButton).setText(activeUser.equals("admin") ? "Administrador" : "UsuarioComun");
	            }
	            if (activeUser.equals("") || !activeUser.equals(e.getSource().equals(adminButton) ? "admin" : "user")) {
	                activeUser = e.getSource().equals(adminButton) ? "admin" : "user";
	                ((JButton)e.getSource()).setText((activeUser.equals("admin") ? "Administrador" : "UsuarioComun") +
	                        " complete y nuevamente click");
	                userLabel.setVisible(true);
	                P5.setVisible(true);
	            } else {
	                if (activeUser.equals(e.getSource().equals(adminButton) ? "admin" : "user")) {
	                    activeUser = "";
	                    userLabel.setVisible(false);
	                    P5.setVisible(false);
	                }
	            }
	        } else if(e.getSource().equals(loginButton)) {
//	        	VentanaError ventana =new VentanaError("Usuario o cleve incorecta");
	    	try {
				UsuarioInvitado.login(codeField.getText(), passField.getText());
			} catch (ErrorLogin e1) {
				// TODO Auto-generated catch block
				VentanaError ventana =new VentanaError("Usuario o cleve incorecta"); 
			}
	            /*

	                AQUÃ� SE DEBE VERIFICAR LOS CREDENCIALES INSERTADOS Y HACER LAS ACCIONES CORRESPONDIENTES, ESTAS SON,
	                MOSTRAR LA EXCEPCIÃ“N INDICADA EN CASO DE ERROR O LOGGEAR EL USUARIO O ADMINISTRADOR Y MOSTRAR LA PRÃ“XIMA
	                PESTAÃ‘A CORRESPONDIENTE DEPENDIENDO DEL TIPO DE ESTE USUARIO

	             */
	        }
}}
