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
		String nombre = data.getString("nombre");
		String usuario = data.getString("usuario");
		String confinado = data.getString("confinado");
		boolean isConfinado= false;
		if(confinado.equals("Si")) {
			isConfinado= true;
		}
		String habitacion = data.getString("habitacion");
		
		JSONArray actividades = data.getJSONArray("listaActividades").getJSONArray(0);
		List<String> listaactividades = new ArrayList<String>();
        for(int i = 0; i < actividades.length(); i++) {
        	System.out.println(actividades.get(i));
        	listaactividades.add(actividades.getString(i));
        
        }
		
		String pagado = data.getString("pagado");
		boolean isPagado= false;
		if(pagado.equals("Si")) {
			isPagado= true;
		}
        TAcampado te = new TAcampado(nombre, usuario, isConfinado, habitacion, listaactividades, isPagado);
		return te;
	}
	


}
