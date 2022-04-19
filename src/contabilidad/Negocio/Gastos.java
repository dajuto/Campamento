package contabilidad.Negocio;

import org.json.JSONObject;

public abstract class Gastos {
	protected String tipo;
	protected String concepto; 
	protected int importe; 
	protected String fecha;
	protected String LoEs; 
	protected String nombre; 


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
	
	public String getLoEs() {
		return LoEs;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public JSONObject report() {  //esto es como escribir en el JSON
		JSONObject contabilidad = new JSONObject();
		contabilidad.accumulate("type", "gastos");
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", this.tipo);
		data.accumulate("Concepto", this.concepto);
		data.accumulate("Importe", this.importe);
		data.accumulate("Fecha", this.fecha); 
		JSONObject empleado = new JSONObject();
		empleado.accumulate("LoEs", this.LoEs);
		empleado.accumulate("Nombre", this.nombre);
		data.accumulate("Empleado", empleado);
		contabilidad.accumulate("data", data);
		return contabilidad;
	}
}

