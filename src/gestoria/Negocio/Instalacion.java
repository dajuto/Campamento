package gestoria.Negocio;

import org.json.JSONObject;

import empleados.Negocio.Empleado;

public abstract class Instalacion {
	protected String codigo;
	protected String nombre;
	protected int superficie;
	protected int precio;
	protected boolean puedeActividades;
	protected boolean pagado;
	
	public String getCodigo() {
		return codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public int getSuperficie() {
		return superficie;
	}


	public int getPrecio() {
		return precio;
	}


	public boolean isPuedeActividades() {
		return puedeActividades;
	}


	public boolean isPagado() {
		return pagado;
	}


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
