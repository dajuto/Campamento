package acampados.Negocio;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Acampado {
	protected String nombre;
	protected String usuario;
	protected boolean confinado;
	protected String habitacion;
	protected List<String> listaactividades;
	protected boolean pagado;
	
	public List<String> getListaactividades() {
		return listaactividades;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public boolean isConfinado() {
		return confinado;
	}
	
	public boolean isPagado() {
		return pagado;
	}
	public String getHabitacion() {
		return habitacion;
	}
	
	public void setConfinado(boolean confinado) {
		this.confinado=confinado;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado=pagado;
	}
	
	public Object report() {
		JSONObject acampado = new JSONObject();
		
		acampado.put("type", "acampado");
		
		JSONObject data = new JSONObject();
		data.put("nombre", nombre);
		data.put("usuario", usuario);
		String isConfinado= "No";
		if(confinado) {
			isConfinado= "Si";
		}
		data.put("confinado", isConfinado);
		data.put("habitacion", habitacion);
		
		
		String actividades = "[";
		for(int j = 0; j < this.listaactividades.size(); j++) {
			actividades += "\"" + this.getListaactividades().get(j) +  "\"";
			if(j!= this.listaactividades.size() - 1 ) {
				actividades += ",";
			}
		}
		actividades += "]";
		data.accumulate("listaActividades", new JSONArray(actividades));
		
		String isPagado= "No";
		if(pagado) {
			isPagado= "Si";
		}
		data.put("pagado", isPagado);
		acampado.put("data", data);
		
		return acampado;
	}
}

