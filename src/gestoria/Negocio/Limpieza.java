package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;

public abstract class Limpieza {
	protected String codigo;
	protected String empleadoEncargado;
	protected String lugar;
	protected String fecha;
	protected String hora;
	
	public String getCodigo() {
		return codigo;
	}
	public String getLugar() {
		return lugar;
	}
	public String getFecha() {
		return fecha;
	}
	public String getHora() {
		return hora;
	}
	public String getEmpleadoEncargado() {
		return empleadoEncargado;
	}

	public JSONObject report() {
		JSONObject limpieza = new JSONObject();
		limpieza.accumulate("type", "limpieza");
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", this.codigo);
		data.accumulate("Lugar", this.lugar);
		data.accumulate("Fecha", this.fecha);
		data.accumulate("Hora", this.hora);
		data.accumulate("Empleado", this.empleadoEncargado);
		limpieza.accumulate("data", data);
		return limpieza;
	}
}
