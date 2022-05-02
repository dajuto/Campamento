package comedor.Integracion;


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

import comedor.Negocio.TMenu;
import launcher.Factory;

public class DaoMenu {
	
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	
	public DaoMenu() throws IOException {
		this.nombreFichero = "comedor.json";
	}
	
	public void escribeTodo(List<TMenu> listaMenu) { 
		JSONObject object = new JSONObject();
		try {
	        for(int i = 0; i < listaMenu.size(); i++) {
	            object.accumulate("comedor", listaMenu.get(i).report());
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
	
	public List<TMenu> leeTodo(Factory<Object> factoriaTranserObjects){ 
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<TMenu> l = new ArrayList<TMenu>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray comedor = jo.getJSONArray("comedor");
            for(int i = 0; i < comedor.length(); i++) {
                TMenu a = (TMenu) factoriaTranserObjects.createInstance(comedor.getJSONObject(i));
                l.add(a);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		return l;
	}
}

