package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class MedicoBuilder extends Builder<Object>{

	
	public MedicoBuilder() {
		super("Medico");
	}

	@Override
	protected Object createTheInstance(JSONObject data) {
		String nombre = data.getString("nombre");
		String puesto = data.getString("puesto");
		String usuario = data.getString("usuario");
		String contrasena = data.getString("contrasena");
		int salario = data.getInt("salario");
		int horario = data.getInt("horario");
		String vacaciones = data.getString("vacaciones");
		
		//lista citas pendientes
		
		JSONObject trabajo = data.getJSONObject("trabajo");
		List<String> citasPendientes = new ArrayList<String>();
		if(trabajo.has("listaCitas")) {
			JSONArray citasAsignadas = trabajo.getJSONArray("listaCitas");
			for(int i = 0; i < citasAsignadas.length(); i++) {
				citasPendientes.add(citasAsignadas.getString(i));
	        }  
		}
		
		
		TMedico templMedico = new TMedico(nombre, puesto,contrasena, usuario, salario, horario, vacaciones, citasPendientes);
		return templMedico;
	}
}
