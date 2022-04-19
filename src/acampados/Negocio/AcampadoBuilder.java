package acampados.Negocio;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import launcher.Builder;

public class AcampadoBuilder extends  Builder<Object> {
	
	public AcampadoBuilder() {
		super("acampado");
	}

	@Override
	protected TAcampado createTheInstance(JSONObject data) { 
		String usuario = data.getString("Usuario");
		String contrasena = data.getString("Contraseña");
		String nombre = data.getString("Nombre");
		String apellidos = data.getString("Apellidos");
		String dni = data.getString("DNI");
		String email = data.getString("Email");
		int edad = data.getInt("Edad");
		int telefono = data.getInt("Telefono");
		String salud = data.getString("Salud");
		String habitacion = data.getString("Habitacion");
		
		JSONObject activi = data.getJSONObject("Actividades");
		List<String> listaActividades = new ArrayList<String>();
		if(activi.has("Lista Actividades")) {
			JSONArray actividades = activi.getJSONArray("Lista Actividades");
			for(int i = 0; i < actividades.length(); i++) {
				listaActividades.add(actividades.getString(i));
	        }  
		}
		
//		JSONArray actividades = data.getJSONArray("listaActividades").getJSONArray(0);
//		List<String> listaactividades = new ArrayList<String>();
//        for(int i = 0; i < actividades.length(); i++) {
//        	System.out.println(actividades.get(i));
//        	listaactividades.add(actividades.getString(i));
//        
//        }
		
		String pagado = data.getString("Pagado");
		boolean isPagado= false;
		if(pagado.equals("Si")) {
			isPagado= true;
		}
        TAcampado te = new TAcampado(usuario, contrasena, nombre, apellidos, dni, email, edad, telefono, salud, habitacion, listaActividades, isPagado);
		return te;
	}
	


}
