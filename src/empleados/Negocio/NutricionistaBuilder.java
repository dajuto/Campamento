package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class NutricionistaBuilder extends Builder<Object>{

	public NutricionistaBuilder() {
		super("Nutricionista");
	}

	@Override
	protected Object createTheInstance(JSONObject data) {
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		JSONObject trabajo = data.getJSONObject("trabajo");
		List<String> listaMenu = new ArrayList<String>();
		if(trabajo.has("listaMenu")) {
			JSONArray comedor = trabajo.getJSONArray("listaMenu");
			for(int i = 0; i < comedor.length(); i++) {
				listaMenu.add(comedor.getString(i));
	        }  
		}
		
		
		
		
		TNutricionista nutricionista = new TNutricionista(usuario, contrasena, nombre, puesto, salario, horario, vacaciones, listaMenu);
		return nutricionista;
	}

}



