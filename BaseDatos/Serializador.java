package BaseDatos;

import gestionAplicacion.cuentas.Cheque;
import gestionAplicacion.cuentas.Cuenta;
import gestionAplicacion.usuarios.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Serializador {

	public static HashMap<String, Usuario> cargar() throws IOException {
		ObjectInputStream in = null;
		ArrayList<Usuario> usuarios = new ArrayList<>();
		HashMap<String, Usuario> tablaUsuarios;

		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));

			/* El primer dato que se lee es el valor del campo estático "contador" de Usuario que se tenía antes de
			 * finalizar la última sesión. Este campo se trata por diferente a los demás ya que el flujo de objetos no
			 * es consistente en el valor de campos estáticos. Una vez leído dicho dato, se le reasigna al
			 * correspondiente campo estático "contador" de Usuario para que reanude el conteo donde lo dejó. */
			Usuario.setContador(in.readInt());
			Cuenta.setContador(in.readInt());
            Cheque.setContador(in.readInt());

			while (true)
				usuarios.add((Usuario) in.readObject());
		} catch (Exception e) {
		} finally {
			if (in != null)
				in.close();
		}

		tablaUsuarios = new HashMap<>(usuarios.size());

		for (Usuario usuario : usuarios)
			tablaUsuarios.put(usuario.getNombreUsuario(), usuario);

		return tablaUsuarios;
	}

	public static void guardar(HashMap<String, Usuario> usuarios) throws IOException {
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));

			/* Se envía manualmente el valor del campo estático "contador" de Usuario instantes antes del fin de la
			 * ejecución de la aplicación, esto para que sea leído de igual forma, manualmente, por la próxima sesión.
			 */
			out.writeInt(Usuario.getContador());
			out.writeInt(Cuenta.getContador());
            out.writeInt(Cheque.getContador());

			for (Map.Entry<String, Usuario> registro : usuarios.entrySet())
				out.writeObject(registro.getValue());
		} finally {
			if (out != null)
				out.close();
		}

	}

}
