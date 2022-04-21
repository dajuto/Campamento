package comedor.negocio;

import org.json.JSONObject;

public abstract class Menu {

	protected String desayuno;
	protected String comida;
	protected String cena;
	protected int horario;
	
	public String getDesayuno() {
		return desayuno;
	}
	public String getComida() {
		return comida;
	}
	public String getCena() {
		return cena;
	}
	public int getHorario() {
		return horario;
	}
	
	public JSONObject report() {
		JSONObject menu = new JSONObject();
		menu.accumulate("type", "Menu");
		JSONObject data = new JSONObject();
		data.accumulate("Desayuno", this.desayuno);
		data.accumulate("Comida", this.comida);
		data.accumulate("Cena", this.cena);
		data.accumulate("Horario", this.horario);
		
		menu.accumulate("data", data);
		return menu;
	}
	
	
	
}
