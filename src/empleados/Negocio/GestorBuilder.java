package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class GestorBuilder extends Builder<Object>{

	public GestorBuilder() {
		super("Gestor");
	}

	@Override
	protected TGestor createTheInstance(JSONObject data) {
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		
		TGestor empleadoLimpieza = new TGestor(usuario, contrasena, nombre, puesto, salario, horario, vacaciones);
		return empleadoLimpieza;
	}

}
