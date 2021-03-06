package contabilidad.Integracion;


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
import contabilidad.Negocio.TIngresos;
import launcher.Factory;


public class DaoIngresos {
	
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	public DaoIngresos() throws IOException {
		this.nombreFichero = "ingresos.json";
	}
	
	public void escribeTodo(List<TIngresos> listaIngresos) { 
		JSONObject object = new JSONObject();
		try {
	        for(int i = 0; i < listaIngresos.size(); i++) {
	            object.accumulate("ingresos", listaIngresos.get(i).report());
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
	
	public List<TIngresos> leeTodo(Factory<Object> factoriaTranserObjects){ 
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<TIngresos> l = new ArrayList<TIngresos>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray ingresos = jo.getJSONArray("ingresos"); //o ingresos
            for(int i = 0; i < ingresos.length(); i++) {
                TIngresos a = (TIngresos) factoriaTranserObjects.createInstance(ingresos.getJSONObject(i));
                l.add(a);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		return l;
	}
}
