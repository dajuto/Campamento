package contabilidad.Negocio;


import org.json.JSONObject;

public abstract class Ingresos {
	
	protected String tipo;
	protected String concepto; 
	protected int importe; 
	protected String fechaContable; 
	protected String nombreAcampado; 
	protected String dniAcampado; 
	protected Boolean contabilizada;  //si contabilizada = true significa que solo se pueden modificar el concepto y el tipo
	//si contabilizada = false, significa que el ingreso aun esta como "guardado" y se puede eliminar o modificar completamente. 
	
	public String getTipo() {
		return tipo;
	}
	public String getConcepto() {
		return concepto;
	}
	public String getFecha() {
		return fechaContable;
	}
	public int getImporte() {
		return importe;
	}
	public String getNombreAcampado() {
		return nombreAcampado;
	}
	
	public String getDniAcampado(){
		return dniAcampado; 
	}

	public Boolean isContabilizada() {
		return contabilizada; 
	}

	
	public JSONObject report() {  //esto es como escribir en el JSON
		JSONObject contabilidad = new JSONObject();
		contabilidad.accumulate("type", "ingresos");
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", this.tipo);
		data.accumulate("Concepto", this.concepto);
		data.accumulate("Importe", this.importe);
		data.accumulate("Fecha contable", this.fechaContable); 
		JSONObject acampado = new JSONObject();
		acampado.accumulate("Nombre", this.nombreAcampado);
		acampado.accumulate("DNI Acampado", this.dniAcampado); 
		data.accumulate("Acampado", acampado);
		
		if (contabilizada) {
			data.accumulate("Contabilizada", "Si");
		}
		else {
			data.accumulate("Contabilizada", "No");
		}
		contabilidad.accumulate("data", data);
		return contabilidad;
	}
}





