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
		int dni = data.getInt("DNI");
		String email = data.getString("Email");
		String salud = data.getString("Salud");
		String habitacion = data.getString("Habitacion");
		
//		JSONArray actividades = data.getJSONArray("listaActividades").getJSONArray(0);
//		List<String> listaactividades = new ArrayList<String>();
//        for(int i = 0; i < actividades.length(); i++) {
//        	System.out.println(actividades.get(i));
//        	listaactividades.add(actividades.getString(i));
//        
//        }
		
		String pagado = data.getString("pagado");
		boolean isPagado= false;
		if(pagado.equals("Si")) {
			isPagado= true;
		}
        TAcampado te = new TAcampado(usuario, contrasena, nombre, apellidos, dni, email, salud, habitacion, isPagado);
		return te;
	}
	


}
