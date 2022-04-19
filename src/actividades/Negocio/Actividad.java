package actividades.Negocio;

import org.json.JSONObject;

public abstract class Actividad {

	protected int id;
	protected String nombre;
	protected String instalacion;
	protected String monitor;
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getInstalacion() {
		return instalacion;
	}
	public String getMonitor() {
		return monitor;
	}
	
	public JSONObject report() {
		JSONObject actividad = new JSONObject();
		actividad.accumulate("type", "Actividad");
		JSONObject data = new JSONObject();
		data.accumulate("Id", this.id);
		data.accumulate("Nombre", this.nombre);
		data.accumulate("Instalacion", this.instalacion);
		data.accumulate("Monitor", this.monitor);
		
		actividad.accumulate("data", data);
		return actividad;
	}
	
	public String toString() {
		return Integer.toString(id);
	}
	
}
