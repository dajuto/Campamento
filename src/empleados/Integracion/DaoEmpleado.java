package empleados.Integracion;

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

import empleados.Negocio.TEmpleado;
import launcher.Factory;

public class DaoEmpleado {
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	public DaoEmpleado() throws IOException {
		this.nombreFichero = "empleados.json";
	}
	
	public void escribeTodo(List<TEmpleado> listaEmpleados) { 
		try {
			this.os = new FileOutputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			JSONObject object = new JSONObject();
	        for(int i = 0; i < listaEmpleados.size(); i++) {
	            object.accumulate("empleados", listaEmpleados.get(i).report());
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
	
	public List<TEmpleado> leeTodo(Factory<Object> factoriaTransferObjects){ // de json a objetos
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
		List<TEmpleado> l = new ArrayList<TEmpleado>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray empleados = jo.getJSONArray("empleados");
            for(int i = 0; i < empleados.length(); i++) {
            	TEmpleado templeado = (TEmpleado) factoriaTransferObjects.createInstance(empleados.getJSONObject(i));
        		l.add(templeado);
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		
		return l;
	}

}
