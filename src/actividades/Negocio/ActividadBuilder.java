package actividades.Negocio;

import org.json.JSONObject;

import launcher.Builder;

public class ActividadBuilder extends Builder<Object>{

	protected ActividadBuilder() {
		super("Actividad");
	}

	@Override
	protected TActividad createTheInstance(JSONObject data) {
		
		int id = data.getInt("Id");
		String nombre = data.getString("Nombre");
		String instalacion = data.getString("Instalacion");
		String monitor = data.getString("Monitor");
		TActividad tactividad = new TActividad(id, nombre, instalacion, monitor);
		
		
		return tactividad;
	}

}
