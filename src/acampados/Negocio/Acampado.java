package acampados.Negocio;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import actividades.Negocio.TActividad;

public class Acampado {
	protected String usuario;
	protected String contrasena;
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String email;
	protected int edad;
	protected int telefono;
	protected String salud;
	protected String habitacion;
	protected List<TActividad> listaActividades; //TODO SEGOVIANO, CAMBIA STRING POR TActividades
	protected boolean pagado;
	
	public String getUsuario() {
		return usuario;
	}

	public String getNombreCompleto() {
		
		return nombre +  " " + apellidos; 
	}
	
	
	public String getContrasena() {
		return contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}

	public String getEmail() {
		return email;
	}

	public int getEdad() {
		return edad;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public String getSalud() {
		return salud;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public List<TActividad> getListaActividades() {
		return listaActividades;
	}

	public boolean isPagado() {
		return pagado;
	}
	
	public void setPagado(boolean pagado) {
		this.pagado=pagado;
	}
	
	public Object report() {
		JSONObject acampado = new JSONObject();
		
		acampado.put("type", "acampado");
		
		JSONObject data = new JSONObject();
		data.put("Usuario", usuario);
		data.put("Contraseña", contrasena);
		data.put("Nombre", nombre);
		data.put("Apellidos", apellidos);
		data.put("DNI", dni);
		data.put("Email", email);
		data.put("Edad", edad);
		data.put("Telefono", telefono);
		data.put("Salud", salud);
		data.put("Habitacion", habitacion);
		
		JSONObject activi = new JSONObject();
		activi.accumulate("ListaActividades", this.getListaActividades());
		data.accumulate("Actividades", activi);
//		String actividades = "[";
//		for(int j = 0; j < this.listaactividades.size(); j++) {
//			actividades += "\"" + this.getListaactividades().get(j) +  "\"";
//			if(j!= this.listaactividades.size() - 1 ) {
//				actividades += ",";
//			}
//		}
//		actividades += "]";
//		data.accumulate("listaActividades", new JSONArray(actividades));
		
		if (pagado) {
			data.put("Pagado", "Si");
		}
		else {
			data.put("Pagado", "No");
		}
		
		acampado.put("data", data);
		
		return acampado;
	}

	
}

