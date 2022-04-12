package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class EmpleadoLimpiezaBuilder extends Builder<Object>{

	public EmpleadoLimpiezaBuilder() {
		super("empleadoMantenimiento");
	}

	@Override
	protected TEmpleadoLimpieza createTheInstance(JSONObject data) {
		int codigo = data.getInt("codigo");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		JSONObject limpieza = data.getJSONObject("limpieza");
		List<String> averiasPendientes = new ArrayList<String>();
		if(limpieza.has("listaLimpieza")) {
			JSONArray averiasAsignadas = limpieza.getJSONArray("listaAverias");
			for(int i = 0; i < averiasAsignadas.length(); i++) {
	        	averiasPendientes.add(averiasAsignadas.getString(i));
	        }  
		}
		TEmpleadoLimpieza empleadoLimpieza = new TEmpleadoLimpieza(codigo, nombre, puesto, salario, horario, vacaciones, averiasPendientes);
		return empleadoLimpieza;
	}

}
