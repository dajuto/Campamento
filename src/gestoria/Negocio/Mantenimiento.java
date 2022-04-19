package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;

public abstract class Mantenimiento {
	protected String codigo;
	protected String nombre;
	protected String descripcion;
	protected String lugar;
	protected int coste;
	protected TEmpleadoMantenimiento empleado;
	protected boolean estado;

	
	


	public JSONObject report() {
		JSONObject instalacion = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", this.codigo);
		data.accumulate("Nombre", this.nombre);
		data.accumulate("Superficie", this.superficie);
		data.accumulate("Precio", this.precio);
		if (pagado) {
			data.accumulate("Pagado", "Si");
		}
		else {
			data.accumulate("Pagado", "No");
		}
		if (puedeActividades) {
			data.accumulate("Actividades", "Si");
		}
		else {
			data.accumulate("Actividades", "No");
		}
		instalacion.accumulate("data", data);
		instalacion.accumulate("type", "instalacion");
		
		return instalacion;
	}
}
