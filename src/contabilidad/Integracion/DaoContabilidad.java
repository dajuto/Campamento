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

import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;
import launcher.Factory;

public class DaoContabilidad {
	private String nombreFichero;
	private InputStream in;
	private OutputStream os;
	public DaoContabilidad() throws IOException {
		this.nombreFichero = "contabilidad.json";
	}
	
	public void escribeTodo(List<TGastos> listaGastos, List <TIngresos> listaIngresos) { 
		try {
			this.os = new FileOutputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			JSONObject object = new JSONObject();
	        for(int i = 0; i < listaGastos.size(); i++) {  //listaGastos.size()
	            object.accumulate("contabilidad", listaGastos.get(i).report());
	        }
	       
	        for(int i = 0; i < listaIngresos.size(); i++) {  
	            object.accumulate("contabilidad", listaIngresos.get(i).report());
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
	
	public List<TGastos> leeTodo(Factory<Object> factoriaTransferObjects){ // de json a objetos
		try {
			this.in = new FileInputStream(this.nombreFichero);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
		List<TGastos> l = new ArrayList<TGastos>();
		try {
            JSONObject jo = new JSONObject(new JSONTokener(in));
            JSONArray contabilidad = jo.getJSONArray("contabilidad");
            for(int i = 0; i < contabilidad.length(); i++) {
            	TGastos tgastos = (TGastos) factoriaTransferObjects.createInstance(contabilidad.getJSONObject(i));
        		l.add(tgastos); //mirar más tarde
            }
        }
        catch (JSONException e) {
            System.out.println("ERROR => La entrada JSON no coincide con la esperada");
        }
		
		return l;
	}


}
