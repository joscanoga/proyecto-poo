package view; 
import javax.imageio.ImageIO;
import javax.swing.*;

import excepciones.ErrorLogin;
import gestionAplicacion.usuarios.Administrador;
import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.usuarios.UsuarioInvitado;
//import uiMain.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


public class Window extends JFrame implements MouseListener, ActionListener {
    Container contentPane;
    JPanel P1, P2, P3, P4, P5, P6,P7;
    Label welcomeLabel, userLabel, codeLabel, passLabel;
    JButton imagesButton, adminButton, userButton, exitButton,loginButton;
    JScrollPane infoTextScrollPane;
    JTextArea infoText;
    JTextField codeField, passField;

    private static byte imageIndex = 0;
    public static  byte getimageIndex() {return imageIndex;}
    final String[] imageSources = {"text.png", "logo.png", "money.png"};

    String activeUser = "";

//    public static void main(String[] args) throws IOException {
//        Window window = new Window();
//    }

    public Window() throws IOException {
        super("Green Bank");
        contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2, 10, 0));

        P1 = new JPanel();
        P1.setLayout(new GridLayout(2, 1, 0, 10));
        welcomeLabel = new Label("Bienvenido");
        welcomeLabel.addMouseListener(this);
        Image img = ImageIO.read(getClass().getResource("text.png"));
        imagesButton = new JButton();
        imagesButton.addActionListener(this);
        imagesButton.setIcon(new ImageIcon(img));
        P1.add(welcomeLabel);
        P1.add(imagesButton);

        P2 = new JPanel();
        P2.setLayout(new GridLayout(2, 1, 0, 10));
        infoText = new JTextArea("que hace el sistema,\n\n\n\n\n\n\n\nquien lo desarrollo\n\n\n\n\n\n\ny como funciona");
        infoText.setLineWrap(true);
        infoText.setEditable(false);
        infoTextScrollPane = new JScrollPane(infoText);

        P3 = new JPanel();
        P3.setLayout(new GridLayout(4,1, 0, 0));
        P4 = new JPanel();
        P7=new JPanel();
        P4.setLayout(new GridLayout(1, 2, 0, 0));
        adminButton = new JButton("Adminsitrador");
        adminButton.addActionListener(this);
        userButton = new JButton("UsuarioComun");
        userButton.addActionListener(this);
        P4.add(adminButton);
        P4.add(userButton);
        P3.add(P4);
        P7.setLayout(new GridLayout(1, 2, 0, 0));
        userLabel = new Label("Ingrese su nombre de usuario y su clave");
        P3.add(userLabel);
        P5 = new JPanel();
        P5.setLayout(new GridLayout(2, 2, 4, 4));
        codeLabel = new Label("nombre de usuario:");
        codeField = new JTextField();
        codeField.addActionListener(this);
        passLabel = new Label("Constrasena:");
        passField = new JTextField();
        passField.addActionListener(this);
        P5.add(codeLabel);
        P5.add(codeField);
        P5.add(passLabel);
        P5.add(passField);
        P3.add(P5);
        exitButton = new JButton("Salir");
        exitButton.addMouseListener(this);
        
        P7.add(exitButton);
        loginButton =new JButton("Iniciar Seccion");
        loginButton.addActionListener(this);
        P7.add(loginButton);
//        P3.add(P7);
        P3.add(exitButton);
        userLabel.setVisible(false);
        P5.setVisible(false);

        P2.add(infoTextScrollPane);
        P2.add(P3);


        contentPane.add(P1);
        contentPane.add(P2);
        setLocation(400, 100);
        setSize(700, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(welcomeLabel)) welcomeLabel.setForeground(Color.blue);
        else {
            Object[] options = {"Si", "No"};
            int n = JOptionPane.showOptionDialog(contentPane,
                    "Desea cerrar la aplicacion?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
            if (n == 0) {
//            	
                /*
                    AQUÃ� SE DEBE LLAMAR EL MÃ‰TODO DE PERSISTENCIA DE DATOS
                 */
                try {
					Usuario.guardarUsuarios();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
                System.exit(0);
            }
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(welcomeLabel)) welcomeLabel.setForeground(Color.black);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
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
//        	VentanaError ventana =new VentanaError("Usuario o cleve incorecta");
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
//                	VentanaError ventana =new VentanaError("Usuario o cleve incorecta");
                    activeUser = "";
                    try {
            			UsuarioInvitado.login(codeField.getText(), passField.getText());
//            			System.out.println(greenBank.GreenBank.getUsuario().getClass().isInstance(new Administrador(0, null, null, null)));
            			if (greenBank.GreenBank.getUsuario().getClass().isInstance(new Administrador(0, null, null, null))) {
            			
            				VentanaAdministrador ventanaAdmin=new VentanaAdministrador();}
            			else { VentanaCliente ventanaC=new VentanaCliente();}
            		} catch (ErrorLogin e1) {
            			// TODO Auto-generated catch block
            			VentanaError ventana =new VentanaError("Usuario o cleve incorecta"); 
            		}
                    userLabel.setVisible(false);
                    P5.setVisible(false);
                }
            }
        }
            /*

                AQUÃ� SE DEBE VERIFICAR LOS CREDENCIALES INSERTADOS Y HACER LAS ACCIONES CORRESPONDIENTES, ESTAS SON,
                MOSTRAR LA EXCEPCIÃ“N INDICADA EN CASO DE ERROR O LOGGEAR EL USUARIO O ADMINISTRADOR Y MOSTRAR LA PRÃ“XIMA
                PESTAÃ‘A CORRESPONDIENTE DEPENDIENDO DEL TIPO DE ESTE USUARIO

             */
        }
//        	try {
//    			UsuarioInvitado.login(codeField.getText(), passField.getText());
//    		} catch (ErrorLogin e1) {
//    			// TODO Auto-generated catch block
//    			VentanaError ventana =new VentanaError("Usuario o cleve incorecta"); 
//    		}
//        
//    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}
}
