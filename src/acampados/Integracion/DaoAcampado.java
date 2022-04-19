package acampados.Integracion;

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

import acampados.Negocio.TAcampado;
import launcher.Factory;

public class DaoAcampado {
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	public DaoAcampado() throws IOException {
		this.nombreFichero = "acampados.json";
	}

	public void escribeTodo(List<TAcampado> listaAcampados) { 
		try {
			this.os = new FileOutputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			JSONObject object = new JSONObject();
	        for(int i = 0; i < listaAcampados.size(); i++) {
	            object.accumulate("acampados", listaAcampados.get(i).report());
	        }
			os.write(object.toString(3).getBytes());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public List<TAcampado> leeTodo(Factory<Object> factoriaTranserObjects){ // de json a objetos
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<TAcampado> l = new ArrayList<TAcampado>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray acampados = jo.getJSONArray("acampados");
            for(int i = 0; i < acampados.length(); i++) {
            	TAcampado tacampado = (TAcampado) factoriaTranserObjects.createInstance(acampados.getJSONObject(i));
                l.add(tacampado);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		return l;
	}
}
