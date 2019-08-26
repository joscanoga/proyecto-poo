package gestionAplicacion.usuarios;
import gestionAplicacion.cuentas.*;
import java.util.*;
import excepciones.*;
public class Cliente extends UsuarioRegistrado {
	ArrayList<Cuenta> cuentas=new ArrayList<Cuenta>();
	public Cliente(int id, String nombreUsuario, String contrasena, String nombre) {
		super(id, nombreUsuario, contrasena, nombre);
		
	}
	public ArrayList<Cuenta> getCuentas(){return (cuentas);}
	public void  anadirCuenta(Cuenta cuenta) {cuentas.add(cuenta);}
	public void removerCuenta(int id) {
		int cont=0;
		for(Cuenta i : cuentas) {
			if(i.getId()==id) {cuentas.remove(cont);}
			else {cont++;}
		}
	}
	public Cuenta getCuenta(int id) throws IdNoValido{
		
		Cuenta cuenta=null;
		
		for(Cuenta i : cuentas) {
			if(i.getId()==id) {cuenta=i;}
			
		}
		if (cuenta.equals(null)) {throw new IdNoValido();}//esta execcion se trata dede donde se llama
		return cuenta;
	}
}
