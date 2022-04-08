package sanidad.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import launcher.Factory;
import launcher.Observable;
import subsistemaActividad.capaIntegracion.SingletonDaoActividad;
import subsistemaMantenimiento.capaIntegraccion.SingletonDaoAveria;
import subsistemaMantenimiento.capaNegocio.TAveria;

public class ServiAppSanidad implements Observable<ActividadObserver> {

	private List<ActividadObserver> observers;
	private List<TActividad> listaActividad;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppSanidad()  {
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
	
	
	/*public void mostrarListaAveriasEmpleado(String nombreEmpleado) {
		this.updateActividad();
		//crearia una tabla con esta lista
	}
*/
	
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
	
	public boolean anadirActividad(int codigoActividad, String lug, String desc, String fecha) {
		this.updateActividad();
		boolean puedo = true;
		for(TActividad ta: this.listaActividad) {
			if(ta.codigo == codigoActividad) {
				puedo = false;
			}
		}
		if(puedo) {
			JSONObject actividad = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.accumulate("lugar", lug);
			data.accumulate("codigo", codigoActividad);
			data.accumulate("descripcion", desc);
			data.accumulate("Fecha", fecha);
			
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
	
	public boolean eliminarActividad(Frame ventanaListaActividad, int codigoActividad) {
		boolean actividad = true;
		for(int i = 0; i < this.listaActividad.size(); i++) {
			if(this.listaActividad.get(i).getCodigo() == codigoActividad) {
					this.listaActividad.remove(i);
					this.guardaActividad();
				    this.onEliminarActividad();
				    i--;
				}
				
		}
		return actividad;
	}
	
}
