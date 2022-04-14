package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;

public abstract class Limpieza {
	protected int codigo;
	protected String empleadoEncargado;
	protected String lugar;
	protected String fecha;
	protected String hora;
	
	public String toString() {
		return Integer.toString(codigo);
	}
	
	public int getCodigo() {
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
		String c = Integer.toString(codigo);
		JSONObject limpieza = new JSONObject();
		limpieza.accumulate("type", "limpieza");
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", c);
		data.accumulate("Lugar", this.lugar);
		data.accumulate("Fecha", this.fecha);
		data.accumulate("Hora", this.hora);
		data.accumulate("Empleado", this.empleadoEncargado);
		limpieza.accumulate("data", data);
		return limpieza;
	}
}
