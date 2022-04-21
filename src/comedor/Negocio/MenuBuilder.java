package comedor.negocio;

import org.json.JSONObject;

import launcher.Builder;

public class MenuBuilder extends Builder<Object>{

	protected MenuBuilder() {
		super("Menu");
	}

	@Override
	protected TMenu createTheInstance(JSONObject data) {
		
		String desayuno = data.getInt("Desayuno");
		String comida = data.getString("Comida");
		String cena = data.getString("Cena");
		String horario = data.getString("Horario");
		TMenu tmenu = new TMenu(desayuno, comida, cena, horario);
		
		
		return tmenu;
	}

}
