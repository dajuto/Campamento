package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;

public abstract class Mantenimiento {
	protected String codigo;
	protected String descripcion;
	protected String lugar;
	protected int coste;
	protected String empleado;
	protected String estado;
	
	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public int getCoste() {
		return coste;
	}
	
	public String getEmpleado() {
		return empleado;
	}

	public String getEstado() {
		return estado;
	}
	
	public JSONObject report() {
		JSONObject averia = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", this.codigo);
		data.accumulate("Descripcion", this.descripcion);
		data.accumulate("Lugar", this.lugar);
		data.accumulate("Coste", this.coste);
		data.accumulate("Empleado", this.empleado);
		data.accumulate("Estado", this.estado);
		
		averia.accumulate("data", data);
		averia.accumulate("type", "averia");
		
		return averia;
	}
}
