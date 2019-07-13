package BaseDatos;

import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.cuentas.*;
import java.io.*;

public class Serializador {

	public static void cargar() throws IOException {
		ObjectInputStream in = null;

		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));
			while (true) {
				System.out.println(in.readObject());
			}
		} catch (Exception e) {
		} finally {
			if (in != null)
				in.close();
		}

	}

	public static void guardar() throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(System.getProperty("user.dir") + "\\src\\temp\\Usuarios.txt")));
			out.writeObject(new Usuario());
			out.writeObject(new Usuario(false, "nick", "pass", "name"));
			out.writeObject(new Usuario(true, "nick", "pass", "admin"));
		} finally {
			if (out != null)
				out.close();
		}

	}

}
