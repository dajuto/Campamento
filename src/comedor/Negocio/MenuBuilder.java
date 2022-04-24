package comedor.negocio;

import org.json.JSONObject;

import launcher.Builder;

public class MenuBuilder extends Builder<Object>{

	protected MenuBuilder() {
		super("Menu");
	}

	@Override
	protected TMenu createTheInstance(JSONObject data) {
		
		String dia = data.getString("Dia");
		String desayuno = data.getInt("Desayuno");
		String comida = data.getString("Comida");
		String cena = data.getString("Cena");
		TMenu tmenu = new TMenu(dia, desayuno, comida, cena);
		
		
		return tmenu;
	}

}
