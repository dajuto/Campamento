package comedor.Negocio;

import org.json.JSONObject;

import launcher.Builder;

public class MenuBuilder extends Builder<Object>{

	public MenuBuilder() {
		super("comedor");
	}

	@Override
	protected TMenu createTheInstance(JSONObject data) {
		
		String dia = data.getString("Dia");
		String desayuno = data.getString("Desayuno");
		String comida = data.getString("Comida");
		String cena = data.getString("Cena");
		TMenu tmenu = new TMenu(dia, desayuno, comida, cena);
		
		
		return tmenu;
	}

}
