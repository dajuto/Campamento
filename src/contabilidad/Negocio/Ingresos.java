package contabilidad.Negocio;


import org.json.JSONObject;

public abstract class Ingresos {
	
	protected String tipo;
	protected String concepto; 
	protected int importe; 
	protected String fecha;
	protected String LoEs; 
	protected String nombreAcampado; 
	protected String dniAcampado; 

	public String getTipo() {
		return tipo;
	}
	public String getConcepto() {
		return concepto;
	}
	public String getFecha() {
		return fecha;
	}


	public JSONObject report() {  //esto es como escribir en el JSON
		JSONObject contabilidad = new JSONObject();
		contabilidad.accumulate("type", "ingresos");
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", this.tipo);
		data.accumulate("Concepto", this.concepto);
		data.accumulate("Importe", this.importe);
		data.accumulate("Fecha", this.fecha); 
		JSONObject acampado = new JSONObject();
		acampado.accumulate("LoEs", this.LoEs);
		acampado.accumulate("Nombre", this.nombreAcampado);
		acampado.accumulate("dniAcampado", this.dniAcampado); 
		data.accumulate("Acampado", acampado);
		contabilidad.accumulate("data", data);
		return contabilidad;
	}
}





