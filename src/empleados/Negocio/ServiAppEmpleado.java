package empleados.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import launcher.Factory;
import launcher.Observable;
import subsistemaAulas.capaNegocio.TReserva;
import subsistemaEmpleado.capaIntegracion.SingletonDaoEmpleado;
import subsistemaMantenimiento.capaIntegraccion.SingletonDaoAveria;
import subsistemaMantenimiento.capaNegocio.MantenimientoObserver;
import subsistemaMantenimiento.capaNegocio.TAveria;

public class ServiAppEmpleado implements Observable<EmpleadoObserver>{
	private List<EmpleadoObserver> observers;
	private Factory<Object> factoriaTransferObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
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

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	public void updateEmpleados() {
		this.listaEmpleados = SingletonDaoEmpleado.getInstance().leeTodo(this.factoriaTransferObjects);
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

	public List<TEmpleadoLimpieza> getListaEmpleadosMantenimiento() {
		this.updateEmpleados();
		List<TEmpleadoLimpieza> l = new ArrayList<>();
		for(TEmpleado e: this.listaEmpleados) {
			if(e.puesto.equals("Empleado Mantenimiento")) {
				l.add((TEmpleadoLimpieza) e);
			}
		}
		return l;
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

	public boolean anadirEmpleado(String usuario, String nombre, String puesto, int sal, int hor, int vac) {
		this.updateEmpleados();;
		boolean puedo = true;
		for(TEmpleado te: this.listaEmpleados) {
			if(te.usuario.equals(usuario)) {
				puedo = false;
			}
		}
		if(puedo) {
			JSONObject empleado = new JSONObject();		
			if(puesto.equals("Empleado Mantenimiento")) {
				this.anadirEmpleadoMantenimiento(usuario, nombre, puesto, sal, hor, vac);
			}
			else {
				JSONObject data = new JSONObject();
				data.put("nombre",nombre);
				data.put("puesto", puesto);
				data.put("usuario", usuario);
				data.put("salario", sal);
				data.put("horario", hor);
				data.put("vacaciones", vac);
				JSONObject trabajo = new JSONObject();
				data.put("trabajo", trabajo);
				
				empleado.put("data", data);
				
				if(puesto.equals("Contable"))
					empleado.put("type", "contable");
				if(puesto.equals("Gestor"))
					empleado.put("type", "gestor");
				if(puesto.equals("Coordinador Covid"))
					empleado.put("type", "coordCovid");
				if(puesto.equals("Director RRHH"))
					empleado.put("type", "directorRRHH");
				if(puesto.equals("Personal Limpieza"))
					empleado.put("type", "limpieza");
				
				TEmpleado te = (TEmpleado) this.factoriaTransferObjects.createInstance(empleado);
				this.listaEmpleados.add(te);
			}
			this.guardaEmpleados();
		    this.onCreateEmpleado();
		    return true;
		}
		else {
			return false;
		}
	}

	private void anadirEmpleadoMantenimiento(String usuario, String nombre, String puesto, int sal, int hor, int vac) {
		JSONObject empleado = new JSONObject();
		
		JSONObject data = new JSONObject();
		data.put("nombre",nombre);
		data.put("puesto", puesto);
		data.put("usuario", usuario);
		data.put("salario", sal);
		data.put("horario", hor);
		data.put("vacaciones", vac);
		
		JSONObject trabajo = new JSONObject();
		data.put("trabajo", trabajo);
		
		empleado.put("type", "empleadoMantenimiento");
		empleado.put("data", data);
		
		TEmpleadoLimpieza te = (TEmpleadoLimpieza) this.factoriaTransferObjects.createInstance(empleado);
		this.listaEmpleados.add(te);
	}

	public boolean eliminarEmpleado(Frame ventanaAnterior, String usuario) {
		for(int i = 0; i < this.listaEmpleados.size(); i++) {
			if(this.listaEmpleados.get(i).usuario == usuario) {
					if(this.listaEmpleados.get(i).getPuesto().equals("Empleado Mantenimiento")) {
						boolean borrar = eliminarEmpleadoMantenimiento((TEmpleadoLimpieza) this.listaEmpleados.get(i));
						if(borrar) {
							this.listaEmpleados.remove(i);
							this.guardaEmpleados();
						    this.onEliminarEmpleado();
						    return true;
						}else {
							return false;
						}
					}
					this.listaEmpleados.remove(i);
					this.guardaEmpleados();
				    this.onEliminarEmpleado();
				    return true;
			}		
		}
		return false;
	}

	public void modificarEmpleado(String usuario, String nombre, String pu, int sal, int hor, int vac) {
		for(TEmpleado tr: this.listaEmpleados) {
			if(tr.usuario == usuario) {
				tr.nombre = nombre;
				tr.puesto = pu;
				tr.salario = sal;
				tr.horario = hor;
				tr.vacaciones = vac;
			
				this.guardaEmpleados();
			    this.onModificarEmpleado();
	}
		}
	}
	
	private boolean eliminarEmpleadoMantenimiento(TEmpleadoLimpieza tEmpleado) {
		// TODO Auto-generated method stub
		if(tEmpleado.horariosLimpieza.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public void anadeAveriaEmpleado(TAveria ta) {
		for(TEmpleadoLimpieza tem: this.getListaEmpleadosMantenimiento()) {
			if(tem.getUsuario().equals(ta.getEmpleadoEncargado().getUsuario())) {
				String codigo = Integer.toString(ta.getCodigo());
				tem.getListLimpieza().add(codigo);
				this.guardaEmpleados();
			}
		}
	}

	public void eliminaAveriaEmpleado(TAveria ta) {
		for(TEmpleado te: this.getListaEmpleados()) {
			if(te.getUsuario().equals(ta.getEmpleadoEncargado().getUsuario())) {
				String codigoAveria = Integer.toString(ta.getCodigo());
				((EmpleadoLimpieza) te).getListLimpieza().remove(codigoAveria);
				this.guardaEmpleados();
			}
		}
	}
	}
