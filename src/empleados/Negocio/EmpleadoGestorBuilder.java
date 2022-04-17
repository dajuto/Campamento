package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class EmpleadoGestorBuilder extends Builder<Object>{

	public EmpleadoGestorBuilder() {
		super("empleadoGestor");
	}

	@Override
	protected TEmpleadoGestoria createTheInstance(JSONObject data) {
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		JSONObject limpieza = data.getJSONObject("trabajo");
		List<String> limpiezaPendiente = new ArrayList<String>();
		if(limpieza.has("listaLimpieza")) {
			JSONArray limpiezaAsignada = limpieza.getJSONArray("listaLimpieza");
			for(int i = 0; i < limpiezaAsignada.length(); i++) {
	        	limpiezaPendiente.add(limpiezaAsignada.getString(i));
	        }  
		}
		TEmpleadoGestoria empleadoLimpieza = new TEmpleadoGestoria(usuario, contrasena, nombre, puesto, salario, horario, vacaciones, limpiezaPendiente);
		return empleadoLimpieza;
	}

}
