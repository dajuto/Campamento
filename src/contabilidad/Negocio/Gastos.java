package contabilidad.Negocio;

import org.json.JSONObject;

public abstract class Gastos {
	protected String tipo;
	protected String concepto; 
	protected int importe; 
	protected String fecha; 
	protected String nombreEmpleado; 
	protected boolean contabilizada;  //nuevo


	public String getTipo() {
		return tipo;
	}
	public String getConcepto() {
		return concepto;
	}
	public String getFecha() {
		return fecha;
	}

	public int getImporte() {
		return importe;
	}

	public String getNombre() {
		return nombreEmpleado;
	}
	
	public boolean isContabilizada() { //nuevo
		return contabilizada; 
	}
	
	public JSONObject report() {  //esto es como escribir en el JSON
		JSONObject contabilidad = new JSONObject();
		contabilidad.accumulate("type", "gastos");
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", this.tipo);
		data.accumulate("Concepto", this.concepto);
		data.accumulate("Importe", this.importe);
		data.accumulate("Fecha de pago", this.fecha); 
		data.accumulate("Empleado", this.nombreEmpleado);
		if (contabilizada) { //nuevo
			data.accumulate("Contabilizada", "Si"); //nuevo
		}
		else { //nuevo
			data.accumulate("Contabilizada", "No"); //nuevo
		}
		contabilidad.accumulate("data", data);
		return contabilidad;
	}
}

