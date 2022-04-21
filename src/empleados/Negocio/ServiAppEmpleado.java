package empleados.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import empleados.Integracion.SingletonDaoEmpleado;
import gestoria.Negocio.TMantenimiento;
import launcher.Factory;
import launcher.Observable;

public class ServiAppEmpleado implements Observable<EmpleadoObserver>{
	private List<EmpleadoObserver> observers;
	private Factory<Object> factoriaTransferObjects;
	private String nombreUsuario;
	private List<TEmpleado> listaEmpleados;
	
	public ServiAppEmpleado() {
		this.listaEmpleados = new ArrayList<TEmpleado>();
		this.observers = new ArrayList<EmpleadoObserver>();

	}
	
	public void registraFactoria(Factory<Object> factoriaTransferObjects) {
		this.factoriaTransferObjects = factoriaTransferObjects;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public void registraUsuario(String text) {
		this.nombreUsuario = text;
	}
	
	public void updateEmpleados() {
		this.listaEmpleados = SingletonDaoEmpleado.getInstance().leeTodo(this.factoriaTransferObjects);
	}
	
	public boolean existeEmpleado(String usuario, String password) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuario) && e.contrasena.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsEmpleado(String usuarioEmpleadoEncargado) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuarioEmpleadoEncargado)) {
				return true;
			}
		}
		return false;
	}

	public TEmpleado getEmpleado(String usuarioEmpleadoEncargado) {
		this.updateEmpleados();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.usuario.equals(usuarioEmpleadoEncargado)) {
				return e;
			}
		}
		return null;
	}

	public void guardaEmpleados() {
        SingletonDaoEmpleado.getInstance().escribeTodo(listaEmpleados);
	}
	
	void onEliminarEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onEliminarEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}
	
	void onCreateEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onCreateEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}
	void onModificarEmpleado() {
		this.updateEmpleados();
		for(EmpleadoObserver o: this.observers) {
			o.onModificarEmpleado(this.listaEmpleados,nombreUsuario);
		}
	}

	public void addObserver(EmpleadoObserver o) {
		this.observers.add(o);
		this.updateEmpleados();
		o.onRegister(listaEmpleados,nombreUsuario);
	}

	public void removeObserver(EmpleadoObserver o) {
		this.observers.remove(o);
	}
	

	public List<TEmpleado> getListaEmpleados() {
		this.updateEmpleados();
		return listaEmpleados;
	}

	public boolean anadirEmpleado(String usuario, String contrasena, String nombre, String puesto) {
		this.updateEmpleados();
		for(TEmpleado te: this.listaEmpleados) {
			if(te.usuario.equals(usuario)) {
				return false;
			}
		}
		JSONObject empleado = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("usuario", usuario);
		data.accumulate("contrasena", contrasena);
		data.accumulate("nombre", nombre);
		data.accumulate("puesto", puesto);
		JSONObject trabajo = new JSONObject();
		data.accumulate("trabajo", trabajo);
		
		if (puesto.equals("Empleado Limpieza")) {
			data.accumulate("salario", 1400);
			data.accumulate("horario", 8);
			data.accumulate("vacaciones", "Navidades");
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Empleado Limpieza");
			TEmpleadoLimpieza tEmpleado = (TEmpleadoLimpieza) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		else if (puesto.equals("Empleado Mantenimiento")) {
			data.accumulate("salario", 2000);
			data.accumulate("horario", 9);
			data.accumulate("vacaciones", "Nunca");
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Empleado Mantenimiento");
			TEmpleadoMantenimiento tEmpleado = (TEmpleadoMantenimiento) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		else if (puesto.equals("Gestor")) {
			data.accumulate("salario", 3500);
			data.accumulate("horario", 8);
			data.accumulate("vacaciones", "Todo el verano");
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Gestor");
			TGestor tEmpleado = (TGestor) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		else if (puesto.equals("Medico")) {
			data.accumulate("salario", 8000);
			data.accumulate("horario", 8);
			data.accumulate("vacaciones", "Todo el verano");
			empleado.accumulate("data", data);
			empleado.accumulate("type", "Medico");
			TMedico tEmpleado = (TMedico) this.factoriaTransferObjects.createInstance(empleado);
			this.listaEmpleados.add(tEmpleado);
		}
		
		this.guardaEmpleados();
	    this.onCreateEmpleado();
		return true;
	}

	public void modificarEmpleadoLimpieza(String empleado, String codigo) {
		for(TEmpleado e: this.listaEmpleados) {
			if(e.nombre.equals(empleado) && e.puesto.equals("Empleado Limpieza")) {
				TEmpleadoLimpieza te = (TEmpleadoLimpieza) e;
				if (te.horariosLimpieza.isEmpty()) {
					te.horariosLimpieza.add(codigo);
				}
				else {
					boolean eliminado = false;
					for (int i = 0; i < te.horariosLimpieza.size(); i++) {
						if (te.horariosLimpieza.get(i).matches(codigo)) {
							te.horariosLimpieza.remove(i);
							eliminado = true;
						}
					}
					if (!eliminado) {
						te.horariosLimpieza.add(codigo);
					}
				}
				
				JSONArray a = new JSONArray();
				for (int i = 0; i < te.horariosLimpieza.size(); i++) {
					a.put(te.horariosLimpieza.get(i));
				}
				JSONObject trabajo = new JSONObject();
				trabajo.accumulate("listaLimpieza", a);
				e.trabajo = trabajo; 
				e = te;
				this.guardaEmpleados();
				
			}
		}
	}

	public void modificarEmpleadoMantenimiento(String empleado, String codigo) {
		for(TEmpleado e: this.listaEmpleados) {
			if(e.nombre.equals(empleado) && e.puesto.equals("Empleado Mantenimiento")) {
				TEmpleadoMantenimiento te = (TEmpleadoMantenimiento) e;
				if (te.listaAverias.isEmpty()) {
					te.listaAverias.add(codigo);
				}
				else {
					boolean eliminado = false;
					for (int i = 0; i < te.listaAverias.size(); i++) {
						if (te.listaAverias.get(i).matches(codigo)) {
							te.listaAverias.remove(i);
							eliminado = true;
						}
					}
					if (!eliminado) {
						te.listaAverias.add(codigo);
					}
				}
				
				JSONArray a = new JSONArray();
				for (int i = 0; i < te.listaAverias.size(); i++) {
					a.put(te.listaAverias.get(i));
				}
				JSONObject trabajo = new JSONObject();
				trabajo.accumulate("listaAverias", a);
				e.trabajo = trabajo; 
				e = te;
				this.guardaEmpleados();
				
			}
		}
	}
	
		
	
	
	}
