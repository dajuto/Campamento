package comedor.Negocio;

import org.json.JSONObject;

public abstract class Menu {

	protected String dia;
	protected String desayuno;
	protected String comida;
	protected String cena;
	
	public String getDia() {
		return dia;
	}
	public String getDesayuno() {
		return desayuno;
	}
	public String getComida() {
		return comida;
	}
	public String getCena() {
		return cena;
	}
	
	public JSONObject report() {
		JSONObject comedor = new JSONObject();
		comedor.accumulate("type", "comedor");
		JSONObject data = new JSONObject();
		data.accumulate("Dia", this.dia);
		data.accumulate("Desayuno", this.desayuno); 
		data.accumulate("Desayuno", desayuno);
		data.accumulate("Comida", this.comida);
		data.accumulate("Cena", this.cena);
		
		
		comedor.accumulate("data", data);
		return comedor;
	}
	
	
	
}
