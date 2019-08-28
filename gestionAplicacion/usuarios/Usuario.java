package gestionAplicacion.usuarios;

import gestionAplicacion.cuentas.Cuenta;
//import uiMain.MenuDeConsola;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import BaseDatos.Serializador;

public abstract class Usuario implements Serializable {
    private final int id;
//    private MenuDeConsola menu;
    protected String nombreUsuario;

    private static int numeroUsuarios;
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
//    private boolean admin;
//    public boolean getAdmin() {return admin;}
//    public void setAdmin(boolean t) {admin=t;}
    //constructor de la clase "padre" Usuario
    public Usuario(int id,String nombreUsuario) {
        this.id = id;
        this.nombreUsuario=nombreUsuario;
        //menu = menuDefectoInvitado;
       }
    public void setNombreUsuario(String nom) {nombreUsuario=nom;}
    public String getNombreUsuario() { return nombreUsuario; }
    public int getId() { return id; }
    public String   getTipoUsuario() {return(this.getClass().getSimpleName());}
    public static int getNumeroUsuarios() {return(numeroUsuarios);}
    public static void agregarUsuario(UsuarioRegistrado usuario) {
    	usuarios.add(usuario);}
    public static ArrayList<Usuario> getUsuarios() {return(usuarios);}
    public static  void setNumeroUsuarios(int cant) {numeroUsuarios=cant;}
    public static void  cargarUsusario() throws IOException {usuarios.addAll(Serializador.cargar()) ;}
    public static void guardarUsuarios() throws IOException {Serializador.guardar(usuarios);}
    
    
    
    
    
//    private final MenuDeConsola menuDefectoInvitado = new MenuDeConsola(new String[]{"Registrarse", "IniciarSesion",
//            "Contactenos"}),
//            menuDefectoRegistrado = new MenuDeConsola(new String[]{"CerrarSesion", "CambiarContrasena", "CrearCDT",
//                    "CrearCuentaCredito", "CrearCuentaDebito", "VerCuentas"}),
//            menuDefectoAdmin = new MenuDeConsola(new String[]{"CerrarSesion", "CambiarContrasena", "AnadirOpcion",
//                    "RemoverOpcion", "VerTodasLasOpciones", "VerOpcionesDeUnUsuario", "NombrarNuevoAdministrador",
//                    "VerUsuarios"});


    // Constructor para usuarios de tipo administrador y registrado
//    public Usuario(boolean esAdmin, String nombreUsuario, String contrasena, String nombre) {
//        id = ++numeroUsuarios;
//        this.esAdmin = esAdmin;
//        this.nombreUsuario = nombreUsuario;
//        this.contrasena = contrasena;
//        this.nombre = nombre;
//
//        if (esAdmin) menu = menuDefectoAdmin;
//        else menu = menuDefectoRegistrado;
//    }

    

//    public MenuDeConsola getMenu() { return menu; }

   



//    public static int getNumeroUsuarios() { return numeroUsuarios; }

  



//    public static void setNumeroUsuarios(int cont) { numeroUsuarios = cont; }

//    public void anadirCuenta(Cuenta cuenta) {
//        System.out.println(cuentas);
//        cuentas.add(cuenta);
//    }
}
