package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;
import empleados.Negocio.TEmpleadoLimpieza;

public abstract class Limpieza {
	protected String codigo;
	protected String lugar;
	protected String dia;
	protected String hora;
	protected String empleadoEncargado;
	
	public String getCodigo() {
		return codigo;
	}
	public String getLugar() {
		return lugar;
	}
	public String getDia() {
		return dia;
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
		data.accumulate("Dia", this.dia);
		data.accumulate("Hora", this.hora);
		data.accumulate("Empleado", this.empleadoEncargado);
		limpieza.accumulate("data", data);
		return limpieza;
	}
}
