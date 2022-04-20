package gestoria.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Integracion.SingletonDaoInstalacion;
import gestoria.Integracion.SingletonDaoLimpieza;
import gestoria.Integracion.SingletonDaoMantenimiento;
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;
import launcher.Observable;

public class ServiAppGestoria implements Observable<GestoriaObserver>{
	private List<GestoriaObserver> observers;
	private List<TLimpieza> listaLimpieza;
	private List<TInstalacion> listaInstalaciones;
	private List<TMantenimiento> listaAverias;
	private List<TEmpleadoLimpieza> listaEmpleadosLimpieza;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppGestoria() {
		this.listaLimpieza = new ArrayList<TLimpieza>();
		this.listaEmpleadosLimpieza = new ArrayList<TEmpleadoLimpieza>();
		this.observers = new ArrayList<GestoriaObserver>();
	}
	
	public void updateLimpieza() {
		this.listaLimpieza = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	public void updateInstalaciones() {
		this.listaInstalaciones = SingletonDaoInstalacion.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	public void updateMantenimiento() {
		this.listaAverias = SingletonDaoMantenimiento.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
//	private void updateEmpleadosLimpieza() {
//		this.listaEmpleadosLimpieza = SingletonControllerGestoria.getInstance().getListaEmpleadosLimpieza();
//	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}

	public void mostrarListaLimpiezaEmpleado(String nombreEmpleado) {
		this.updateLimpieza();
	}
	
	@Override
	public void addObserver(GestoriaObserver o) {
		this.observers.add(o);
		this.updateLimpieza();
		this.updateInstalaciones();
		this.updateMantenimiento();
		//this.updateEmpleadosLimpieza();
		o.onRegister(listaLimpieza, listaInstalaciones, listaAverias, listaEmpleadosLimpieza, nombreUsuario);
	}

	@Override
	public void removeObserver(GestoriaObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TLimpieza> getListaLimpieza() {	
		this.updateLimpieza();
		return listaLimpieza;
	}
	
	public List<TInstalacion> getListaInstalaciones() {
		updateInstalaciones();
		return listaInstalaciones;
	}
	
	public List<TMantenimiento> getListaMantenimiento() {
		updateMantenimiento();
		return listaAverias;
	}

	public void guardaLimpieza() {
        SingletonDaoLimpieza.getInstance().escribeTodo(this.listaLimpieza);
	}
	
	public void guardaInstalacion() {
        SingletonDaoInstalacion.getInstance().escribeTodo(this.listaInstalaciones);
	}
	
	private void guardaAveria() {
		SingletonDaoMantenimiento.getInstance().escribeTodo(this.listaAverias);
	}
	
	public boolean añadirLimpieza(String codigo, String lugar, String fecha, String hora, String empleado, JFrame frame) {
		this.updateLimpieza();
		for(TLimpieza ta: this.listaLimpieza) {
			if(ta.codigo.equals(codigo)) {
				return false;
			}
		}
		JSONObject limpieza = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", codigo);
		data.accumulate("Lugar", lugar);
		data.accumulate("Fecha", fecha);
		data.accumulate("Hora", hora);
		data.accumulate("Empleado", empleado);
		
		limpieza.accumulate("data", data);
		limpieza.accumulate("type", "limpieza");
		
		TLimpieza tLimpieza = (TLimpieza) this.factoriaTranserObjects.createInstance(limpieza);
		this.listaLimpieza.add(tLimpieza);
		this.guardaLimpieza();
		this.updateLimpieza();
		
		return true;
	}

	public void eliminarLimpieza(JFrame frame, String codigo) {
		for (int i = 0; i < listaLimpieza.size(); i++) {
			if (listaLimpieza.get(i).getCodigo().equals(codigo)) {
				//TODO empleado limpieza aguita de coco
				listaLimpieza.remove(i);
				SingletonDaoLimpieza.getInstance().escribeTodo(listaLimpieza);
				this.updateLimpieza();
			}
		}
	}

	public void modificarLimpieza(String codigo, String lugar, String fecha, String hora, String empleado) {
		for (int i = 0; i < listaLimpieza.size(); i++) {
			if (listaLimpieza.get(i).getCodigo().equals(codigo)) {
				listaLimpieza.get(i).codigo = codigo;
				listaLimpieza.get(i).lugar = lugar;
				listaLimpieza.get(i).fecha = fecha;
				listaLimpieza.get(i).hora = hora;
				listaLimpieza.get(i).empleadoEncargado = empleado;
				SingletonDaoLimpieza.getInstance().escribeTodo(listaLimpieza);
				this.updateLimpieza();
			}
		}
		
	}

	public boolean añadirInstalacion(String codigo, String nombre, String superficie, String precio, boolean actividades,
			JFrame frame) {
		this.updateInstalaciones();
		for(TInstalacion ti: this.listaInstalaciones) {
			if(ti.codigo.equals(codigo)) {
				return false;
			}
		}
		JSONObject instalacion = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", codigo);
		data.accumulate("Nombre", nombre);
		data.accumulate("Superficie", superficie);
		data.accumulate("Precio", precio);
		data.accumulate("Pagado", "No");
		if (actividades) {
			data.accumulate("Actividades", "Si");
		}
		else {
			data.accumulate("Actividades", "No");
		}
		
		instalacion.accumulate("data", data);
		instalacion.accumulate("type", "instalacion");
		
		TInstalacion tinstalacion = (TInstalacion) this.factoriaTranserObjects.createInstance(instalacion);
		this.listaInstalaciones.add(tinstalacion);
		this.guardaInstalacion();
		this.updateInstalaciones();
		
		return true;
	}

	public void eliminarInstalacion(JFrame frame, String codigo) {
		for (int i = 0; i < listaInstalaciones.size(); i++) {
			if (listaInstalaciones.get(i).getCodigo().equals(codigo)) {
				listaInstalaciones.remove(i);
				SingletonDaoInstalacion.getInstance().escribeTodo(listaInstalaciones);
				this.updateInstalaciones();
			}
		}
	}

	public void modificarInstalacion(String codigo, String nombre, String superficie, String precio, boolean pagado,
			boolean actividades) {
		for (int i = 0; i < listaInstalaciones.size(); i++) {
			if (listaInstalaciones.get(i).getCodigo().equals(codigo)) {
				listaInstalaciones.get(i).nombre = nombre;
				listaInstalaciones.get(i).superficie = Integer.parseInt(superficie);
				listaInstalaciones.get(i).precio = Integer.parseInt(precio);
				listaInstalaciones.get(i).pagado = pagado;
				listaInstalaciones.get(i).puedeActividades = actividades;
				SingletonDaoInstalacion.getInstance().escribeTodo(listaInstalaciones);
				this.updateLimpieza();
			}
		}
	}

	public boolean añadirMantenimiento(String codigo, String descripcion, String lugar, String coste, String empleado) {
		this.updateMantenimiento();
		for(TMantenimiento ta: this.listaAverias) {
			if(ta.codigo.equals(codigo)) {
				return false;
			}
		}
		JSONObject averia = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", codigo);
		data.accumulate("Descripcion", descripcion);
		data.accumulate("Lugar", lugar);
		data.accumulate("Coste", coste);
		data.accumulate("Empleado", empleado);
		data.accumulate("Estado", "Sin reparar");
		
		averia.accumulate("data", data);
		averia.accumulate("type", "averia");
		
		TMantenimiento taveria = (TMantenimiento) this.factoriaTranserObjects.createInstance(averia);
		this.listaAverias.add(taveria);
		this.guardaAveria();
		this.updateMantenimiento();
		
		return true;
	}

	public void modificarMantenimiento(String codigo, String descripcion, String lugar, String coste, String empleado,
			String estado) {
		for (int i = 0; i < listaAverias.size(); i++) {
			if (listaAverias.get(i).getCodigo().equals(codigo)) {
				listaAverias.get(i).descripcion = descripcion;
				listaAverias.get(i).lugar = lugar;
				listaAverias.get(i).coste = Integer.parseInt(coste);
				listaAverias.get(i).empleado = empleado;
				listaAverias.get(i).estado = estado;
				SingletonDaoMantenimiento.getInstance().escribeTodo(listaAverias);
				this.updateMantenimiento();
			}
		}
	}

	
	

	

	

	

	
}
