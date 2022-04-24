package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class GestorActividadesBuilder extends Builder<Object>{

	public GestorActividadesBuilder() {
		super("Gestor Actividades");
	}

	@Override
	protected TGestorActividades createTheInstance(JSONObject data) {
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		JSONObject trabajo = data.getJSONObject("trabajo");
		List<String> listaActividades = new ArrayList<String>();
		if(trabajo.has("listaActividades")) {
			JSONArray actividades = trabajo.getJSONArray("listaActividades");
			for(int i = 0; i < actividades.length(); i++) {
				listaActividades.add(actividades.getString(i));
	        }  
		}
		
		
		
		
		TGestorActividades gestorActividades = new TGestorActividades(usuario, contrasena, nombre, puesto, salario, horario, vacaciones, listaActividades);
		return gestorActividades;
	}

}