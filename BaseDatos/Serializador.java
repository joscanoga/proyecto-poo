package BaseDatos;

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

			for (Map.Entry<String, Usuario> registro : usuarios.entrySet())
				out.writeObject(registro.getValue());
		} finally {
			if (out != null)
				out.close();
		}

	}

}
