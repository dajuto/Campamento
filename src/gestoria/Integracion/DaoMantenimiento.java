package gestoria.Integracion;

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

import gestoria.Negocio.TLimpieza;
import gestoria.Negocio.TMantenimiento;
import launcher.Factory;

public class DaoMantenimiento {
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	public DaoMantenimiento() throws IOException {
		this.nombreFichero = "averias.json";
	}
	
	public void escribeTodo(List<TMantenimiento> listaLimpieza) { 
		JSONObject object = new JSONObject();
		try {
	        for(int i = 0; i < listaLimpieza.size(); i++) {
	            object.accumulate("averias", listaLimpieza.get(i).report());
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
	
	public List<TMantenimiento> leeTodo(Factory<Object> factoriaTranserObjects){ // de json a objetos
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<TMantenimiento> l = new ArrayList<TMantenimiento>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray listaAverias = jo.getJSONArray("averias");
            for(int i = 0; i < listaAverias.length(); i++) {
            	TMantenimiento m = (TMantenimiento) factoriaTranserObjects.createInstance(listaAverias.getJSONObject(i));
                l.add(m);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		return l;
	}
}
