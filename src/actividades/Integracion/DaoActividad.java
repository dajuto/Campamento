package actividades.Integracion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import actividades.Negocio.TActividad;
import launcher.Factory;

public class DaoActividad {

	private String nombreFichero;
	private InputStream in;
	private OutputStream os;

	public DaoActividad() throws IOException {
		this.nombreFichero = "actividad.json";
	}
	
	public void escribeTodo(List<TActividad>listaActividad) { // de objetos a json
		JSONObject object = new JSONObject();
		try {
	        for(int i = 0; i < listaActividad.size(); i++) {
	            object.accumulate("actividad", listaActividad.get(i).report());
	        }
			this.os = new FileOutputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			os.write(object.toString(3).getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public List<TActividad> leeTodo(Factory<Object> factoriaTranserObjects){ // de json a objetos
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
		
		List<TActividad> l = new ArrayList<TActividad>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray actividad = jo.getJSONArray("actividad");
            for(int i = 0; i < actividad.length(); i++) {
                TActividad a = (TActividad) factoriaTranserObjects.createInstance(actividad.getJSONObject(i));
                l.add(a);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR : ACTIVIDAD");
        }
		return l;
	}
	
}
