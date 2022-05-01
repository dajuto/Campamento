package actividades.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import actividades.Integracion.SingletonDaoActividad;
import launcher.Factory;
import launcher.Observable;

public class ServiAppActividad implements Observable<ActividadObserver>{

	private List<ActividadObserver> observers;
	private List<TActividad> listaActividad;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppActividad() {
		this.listaActividad = new ArrayList<TActividad>();
		this.observers = new ArrayList<ActividadObserver>();
	}
	
	public void updateActividad() {
		this.listaActividad = SingletonDaoActividad.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	void onCreateActividad() {
		this.updateActividad();
		for(ActividadObserver o: this.observers) {
			o.onCreateActividad(this.listaActividad);
		}
	}
	void onEliminarActividad() {
		this.updateActividad();
		for(ActividadObserver o: this.observers) {
			o.onEliminarActividad(this.listaActividad);
		}
	}

	
	
	@Override
	public void addObserver(ActividadObserver o) {
		this.observers.add(o);
		this.updateActividad();
		o.onRegister(listaActividad);
	}

	@Override
	public void removeObserver(ActividadObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TActividad> getListaActividades() {
		this.updateActividad();
		return listaActividad;
	}

	public void guardaActividad() {
		
      SingletonDaoActividad.getInstance().escribeTodo(listaActividad);
	}
	
	public boolean anadirActividad(int idActividad, String nombre, String instalacion, String monitor) {
		this.updateActividad();
		boolean puedo = true;
		for(TActividad ta: this.listaActividad) {
			if(ta.id == idActividad) {
				puedo = false;
			}
		}
		if(puedo) {
			JSONObject actividad = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.accumulate("Instalacion", instalacion);
			data.accumulate("Id", idActividad);
			data.accumulate("Monitor", monitor);
			data.accumulate("Nombre", nombre);
			
			actividad.accumulate("data", data);
			actividad.accumulate("type", "actividad");
			
			TActividad ta = (TActividad) this.factoriaTranserObjects.createInstance(actividad);
			this.listaActividad.add(ta);
			this.guardaActividad();
		    this.onCreateActividad();
		    return true;
		}
		else {
			return false;
		}
	}
	
	public boolean eliminarActividad(Frame ventanaListaActividad, int idActividad) {
		boolean actividad = true;
		for(int i = 0; i < this.listaActividad.size(); i++) {
			if(this.listaActividad.get(i).getId() == idActividad) {
					this.listaActividad.remove(i);
					this.guardaActividad();
				    this.onEliminarActividad();
				    i--;
				}
				
		}
		return actividad;
	}
	
	public boolean modificarActividad(int idActividad, String nombre, String instalacion, String monitor) {
		boolean actividad = true;
		for(int i = 0; i < this.listaActividad.size(); i++) {
			if(this.listaActividad.get(i).getId() == idActividad) {
				this.listaActividad.get(i).nombre = nombre;
				this.listaActividad.get(i).instalacion = instalacion;
				this.listaActividad.get(i).monitor = monitor;
				SingletonDaoActividad.getInstance().escribeTodo(listaActividad);
				this.updateActividad();
				
			}
				
		}
		return actividad;
	}
	
}
