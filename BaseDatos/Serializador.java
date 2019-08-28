package BaseDatos;

import gestionAplicacion.cuentas.Cheque;
import gestionAplicacion.cuentas.Credito;
import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.cuentas.Debito;
import gestionAplicacion.usuarios.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Serializador {

	public static ArrayList<Usuario> cargar() throws IOException {
		ObjectInputStream in = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		HashMap<String, Usuario> tablaUsuarios;

		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));

			/* El primer dato que se lee es el valor del campo estático "cantCuentas" de Usuario que se tenía antes de
			 * finalizar la última sesión. Este campo se trata por diferente a los demás ya que el flujo de objetos no
			 * es consistente en el valor de campos estáticos. Una vez leído dicho dato, se le reasigna al
			 * correspondiente campo estático "cantCuentas" de Usuario para que reanude el conteo donde lo dejó. */
			Usuario.setNumeroUsuarios(in.readInt());
			Cuenta.setContador(in.readInt());
            Cheque.setContador(in.readInt());
            Debito.setContador(in.readInt());
            Credito.setContador(in.readInt());

			while (true)
				usuarios.add((Usuario) in.readObject());
		} catch (Exception e) {
		} finally {
			if (in != null)
				in.close();
		}

//		tablaUsuarios = new HashMap<>(usuarios.size());
//
//		for (Usuario usuario : usuarios)
//			tablaUsuarios.put(usuario.getNombreUsuario(), usuario);

		return usuarios;
	}

	public static void guardar(ArrayList<Usuario> usuarios) throws IOException {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));

			/* Se envía manualmente el valor del campo estático "cantCuentas" de Usuario instantes antes del fin de la
			 * ejecución de la aplicación, esto para que sea leído de igual forma, manualmente, por la próxima sesión.
			 */
			out.writeInt(Usuario.getNumeroUsuarios());
			out.writeInt(Cuenta.getContador());
            out.writeInt(Cheque.getContador());
            out.writeInt(Debito.getContador());
            out.writeInt(Credito.getContador());

			for (Usuario registro : usuarios)
				out.writeObject(registro);
		} finally {
			if (out != null)
				out.close();
		}

	}

}
