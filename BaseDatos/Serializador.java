package BaseDatos;

import gestionAplicacion.usuarios.Usuario;
import gestionAplicacion.cuentas.*;
import java.io.*;

public class Serializador {

	public static void Test() throws IOException {
		ObjectOutputStream out = null;
		ObjectInputStream in = null;
		
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream( "C:\\Users\\juan_\\bank\\temp\\Usuarios.txt" )));
			out.writeObject(new simpleObject());
		} finally {
			if (out != null)
				out.close();
		}

		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream( "C:\\Users\\juan_\\bank\\temp\\Usuarios.txt" )));
			System.out.println(in.readObject());
		} catch (Exception e) {} finally {
			if (in != null)
				in.close();
		}

	}

}

class simpleObject implements Serializable{
	int number = 1;
	String word = "Text";
	
	@Override
	public String toString() {
		return "simpleObject [number=" + number + ", word=" + word + "]";
	}
	
	
}
