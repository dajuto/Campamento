package gestoria.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import launcher.Factory;
import launcher.Observable;
import subsistemaEmpleado.capaNegocio.TEmpleadoMantenimiento;
import subsistemaMantenimiento.capaIntegraccion.SingletonDaoAveria;
import subsistemaMantenimiento.capaPresentacion.SingletonControllerMantenimiento;

public class ServiAppGestoria implements Observable<MantenimientoObserver>{
	private List<MantenimientoObserver> observers;
	private List<TLimpieza> listaAverias;
	private List<TEmpleadoMantenimiento> listaEmpleadosMantenimiento;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppGestoria() {
		this.listaAverias = new ArrayList<TLimpieza>();
		this.listaEmpleadosMantenimiento = new ArrayList<TEmpleadoMantenimiento>();
		this.observers = new ArrayList<MantenimientoObserver>();
	}
	
	public void updateAverias() {
		this.listaAverias = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	public void updateEmpleadosMantenimiento() {
		this.listaEmpleadosMantenimiento = SingletonControllerGestoria.getInstance().getListaEmpleadosMantenimiento();	
	}
	
	public void guardaAverias() {
        SingletonDaoLimpieza.getInstance().escribeTodo(this.listaAverias);
	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}

	/*public void mostrarListaAveriasEmpleado(String nombreEmpleado) {
		this.updateAverias();
		//crearia una tabla con esta lista
	}*/

	void onCreateAveria() {
		this.updateAverias();
		this.updateEmpleadosMantenimiento();
		for(MantenimientoObserver o: this.observers) {
			o.onCreateAveria(this.listaAverias, listaEmpleadosMantenimiento, nombreUsuario);
		}
	}
	void onEliminarAveria() {
		this.updateAverias();
		this.updateEmpleadosMantenimiento();
		for(MantenimientoObserver o: this.observers) {
			o.onEliminarAveria(this.listaAverias, listaEmpleadosMantenimiento, nombreUsuario);
		}
	}
	void onModificarAveria() {
		this.updateAverias();
		//this.updateEmpleadosMantenimiento();
		for(MantenimientoObserver o: this.observers) {
			o.onModificarAveria(this.listaAverias, listaEmpleadosMantenimiento, nombreUsuario);
		}
	}

	@Override
	public void addObserver(MantenimientoObserver o) {
		this.observers.add(o);
		this.updateAverias();
		this.updateEmpleadosMantenimiento();
		o.onRegister(listaAverias, listaEmpleadosMantenimiento, nombreUsuario);
	}

	@Override
	public void removeObserver(MantenimientoObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TLimpieza> getListaAveriasGestor() {
		this.updateAverias();
		return listaAverias;
	}
	
	public List<TLimpieza> getListaAveriasEmpleado(String usuarioEmpleadoMantenimiento) {
		this.updateAverias();
		List<TLimpieza> l = new ArrayList<>();
		for(TLimpieza e: this.listaAverias) {
			if(e.empleadoEncargado.getUsuario().equals(usuarioEmpleadoMantenimiento)) {
				l.add(e);
			}
		}
		return l;
	}

	public boolean anadirAveria(int codigoAveria, String lug, String desc, String usuarioEmpleadoEncargado) {
		this.updateAverias();
		boolean puedo = true;
		for(TLimpieza ta: this.listaAverias) {
			if(ta.codigo == codigoAveria) {
				puedo = false;
			}
		}
		if(puedo) {
			JSONObject averia = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.accumulate("estado", "Sin Reparar");
			data.accumulate("usuarioEmpleadoEncargado", usuarioEmpleadoEncargado);
			data.accumulate("descripcion", desc);
			data.accumulate("lugar", lug);
			String codigo = Integer.toString(codigoAveria);
			data.accumulate("codigo", codigo);
			averia.accumulate("data", data);
			averia.accumulate("type", "averia");
			
			TLimpieza ta = (TLimpieza) this.factoriaTranserObjects.createInstance(averia);
			SingletonControllerGestoria.getInstance().anadeAveriaEmpleado(ta);
			this.listaAverias.add(ta);
			this.guardaAverias();
		    this.onCreateAveria();
		    return true;
		}
		else {
			return false;
		}
	}

	public boolean eliminarAveria(Frame ventanaListaAverias, int codigoAveria) {
		boolean averiaReparadaPreviamente = true;
		for(int i = 0; i < this.listaAverias.size(); i++) {
			if(this.listaAverias.get(i).codigo == codigoAveria) {
				if(this.listaAverias.get(i).estado.equals("Reparado")) {
					SingletonControllerGestoria.getInstance().eliminaAveriaEmpleado(this.listaAverias.get(i));
					this.listaAverias.remove(i);
					this.guardaAverias();
				    this.onEliminarAveria();
				    i--;
				}
				else {
					averiaReparadaPreviamente = false;
				}
			}
		}
		return averiaReparadaPreviamente;
	}

	public void modificarEstadoAveriaGestor(int codigoAveria) {
		for(TLimpieza ta: this.listaAverias) {
			if(ta.codigo == codigoAveria) {
				if(ta.estado.equals("Sin Reparar")) {
					ta.estado = "Reparado";
				}
				else {
					ta.estado = "Sin Reparar";
				}
				this.guardaAverias();
			    this.onModificarAveria();
			}
		}
	}

	public void actualizarListaEmpleadosMantenimiento() {
		this.updateEmpleadosMantenimiento();
		onModificarListaEmpleadosMantenimiento();
	}

	private void onModificarListaEmpleadosMantenimiento() {
		for(MantenimientoObserver mo: this.observers) {
			mo.onActualizarListaEmpleadosMantenimiento(this.listaAverias, listaEmpleadosMantenimiento, this.nombreUsuario);
		}
	}

	
}
