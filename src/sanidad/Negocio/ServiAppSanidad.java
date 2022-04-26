package sanidad.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import empleados.Negocio.SingletonServiAppEmpleado;
import empleados.Negocio.TMedico;
import empleados.Presentacion.SingletonControllerEmpleado;
import launcher.Factory;
import launcher.Observable;
import sanidad.Integracion.SingletonDaoCitas;
import sanidad.Integracion.SingletonDaoSanidad;
import sanidad.Presentacion.SingletonControllerSanidad;


public class ServiAppSanidad implements Observable<SanidadObserver> {

	private List<SanidadObserver> observers;
	private List<TReceta> listaRecetas;
	private List<TCita> listaCitas;
	private List<TMedico> listaMedicos;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public ServiAppSanidad()  {
		this.listaRecetas = new ArrayList<TReceta>();
		listaCitas=new ArrayList<TCita>();
		this.listaMedicos=new ArrayList<TMedico>();
		this.observers = new ArrayList<SanidadObserver>();
	}
	
	public void updateRecetas() {
		this.listaRecetas = SingletonDaoSanidad.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	public void updateCitas() {
		this.listaCitas = SingletonDaoCitas.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text) {
		this.nombreUsuario = text;
	}
	
	

	@Override
	public void addObserver(SanidadObserver o) {
		this.observers.add(o);
		this.updateRecetas();
		this.updateCitas();
		o.onRegister(listaRecetas,listaCitas,listaMedicos,nombreUsuario);
	}
	
	@Override
	public void removeObserver(SanidadObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	
	//RECETAS
	
	public List<TReceta> getListaRecetas() {	
		this.updateRecetas();
		return listaRecetas;
	}
	
	public void guardaReceta() {
        SingletonDaoSanidad.getInstance().escribeTodo(this.listaRecetas);
	}

	public void guardaCita() {
		
        SingletonDaoCitas.getInstance().escribeTodo(this.listaCitas);
	}
	
	void onCrear() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onCrear(this.listaRecetas,this.listaCitas,this.listaMedicos,this.nombreUsuario);
		}
	}
	void onEliminar() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onEliminar(listaRecetas, listaCitas, listaMedicos, nombreUsuario);
		}
	}

	void onConsultar() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onConsultar(listaRecetas, listaCitas, listaMedicos, nombreUsuario);
		}
	}

	
	public boolean añadirReceta(int codigo, String medicamento, String dosis, String Nombremedico, String NombreAcampado) {
		this.updateRecetas();
		boolean puedo = true;
		for(TReceta ta: this.listaRecetas) {
			if(ta.codigo == (codigo)) {
				puedo=false;
			}
		}
		if(puedo) {
			JSONObject receta = new JSONObject();
			JSONObject data = new JSONObject();
			String c = Integer.toString(codigo);
			data.accumulate("codigo", c);
			data.accumulate("medicamento", medicamento);
			data.accumulate("dosis", dosis);
			data.accumulate("Nombremedico", Nombremedico);
			data.accumulate("comprado", "Sin Adquirir");
			data.accumulate("NombreAcampado", NombreAcampado);
			
			
			receta.accumulate("data", data);
			receta.accumulate("type", "receta");
			
			TReceta TReceta = (TReceta) this.factoriaTranserObjects.createInstance(receta);
			//SingletonControllerSanidad.getInstance().mostrarEliminarReceta(frame);(this.listaAverias.get(i));
			
			this.listaRecetas.add(TReceta);
			this.guardaReceta();
			this.onCrear();
			
			return true;
		}else {
			return false;
		}
		
	}


	public boolean eliminarReceta(JFrame ventanaListaRecetas, int codigo) {
		boolean recetaCompradoPreviamente = true;
		for(int i = 0; i < this.listaRecetas.size(); i++) {
			if(this.listaRecetas.get(i).codigo == codigo) {
				if(this.listaRecetas.get(i).comprado.equals("Adquirido")) {
					//SingletonControllerSanidad.getInstance().mostrarEliminarReceta(frame);(this.listaAverias.get(i));
					this.listaRecetas.remove(i);
					this.guardaReceta();
				    this.onEliminar();
				    i--;
				}
				else {
					recetaCompradoPreviamente = false;
				}
			}
		}

		return recetaCompradoPreviamente;
	}
	
	public boolean eliminarCita(JFrame ventanaListaRecetas, int codigo) {
		boolean recetaCompradoPreviamente = true;
		for(int i = 0; i < this.listaCitas.size(); i++) {
			if(this.listaCitas.get(i).codigo == codigo) {
				if(this.listaCitas.get(i).atendido.equals("Si")) {
					//SingletonControllerSanidad.getInstance().mostrarEliminarReceta(frame);(this.listaAverias.get(i));
					this.listaCitas.remove(i);
					this.guardaCita();
				    this.onEliminar();
				    i--;
				}
				else {
					recetaCompradoPreviamente = false;
				}
			}
		}

		return recetaCompradoPreviamente;
	}
	
	
	public void consultarCompraReceta(int codigo) {
		for(TReceta ta: this.listaRecetas) {
			if(ta.codigo == codigo) {
				if(ta.comprado.equals("Sin Adquirir")) {
					ta.comprado = "Adquirido";
				}
				else {
					ta.comprado = "Sin Adquirir";
				}
				this.guardaReceta();
			    this.onConsultar();
			}
		}
	}
	
	public void consultarAtencionCita(int codigo) {
		for(TCita ta: this.listaCitas) {
			if(ta.codigo == codigo) {
				if(ta.atendido.equals("No")) {
					ta.atendido = "Si";
				}
				else {
					ta.atendido = "No";
				}
				this.guardaCita();
			    this.onConsultar();
			}
		}
	}
	
	public boolean pedirCita(int codigo, String motivo, String Nombremedico, String NombreAcampado) {
		this.updateCitas();
		boolean puedo = true;
		for(TCita ta: this.listaCitas) {
			if(ta.codigo == (codigo)) {
				puedo=false;
			}
		}
		if(puedo) {
			JSONObject cita = new JSONObject();
			JSONObject data = new JSONObject();
			String c = Integer.toString(codigo);
			data.accumulate("codigo", c);
			data.accumulate("motivo", motivo);
			data.accumulate("Nombremedico", Nombremedico);
			data.accumulate("atendido", "No");
			data.accumulate("NombreAcampado", NombreAcampado);
			
			
			cita.accumulate("data", data);
			cita.accumulate("type", "cita");
			
			TCita Tcita = (TCita) this.factoriaTranserObjects.createInstance(cita);
			//SingletonControllerSanidad.getInstance().mostrarEliminarReceta(frame);(this.listaAverias.get(i));
			
			this.listaCitas.add(Tcita);
			
		
			this.guardaCita();
			this.onCrear();
			
			return true;
		}else {
			return false;
		}
		
	}
	
	public List<TCita> getListaCitas() {	
		this.updateCitas();
		return this.listaCitas;
	}
	
}
