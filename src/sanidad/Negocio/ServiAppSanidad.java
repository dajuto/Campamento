package sanidad.Negocio;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import empleados.Negocio.TMedico;
import gestoria.Integracion.SingletonDaoLimpieza;
import gestoria.Negocio.TLimpieza;
import launcher.Factory;
import launcher.Observable;
import sanidad.Integracion.SingletonDaoSanidad;
import sanidad.Presentacion.SingletonControllerSanidad;


public class ServiAppSanidad implements Observable<SanidadObserver> {

	private List<SanidadObserver> observers;
	private List<TReceta> listaRecetas;
	private List<TMedico> listaMedicos;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppSanidad()  {
		this.listaRecetas = new ArrayList<TReceta>();
		this.listaMedicos=new ArrayList<TMedico>();
		this.observers = new ArrayList<SanidadObserver>();
	}
	
	public void updateRecetas() {
		this.listaRecetas = SingletonDaoSanidad.getInstance().leeTodo(this.factoriaTranserObjects);
		
	}
	

	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	
	
	public void mostrarlistaMedicos(String nombreEmpleado) {
		this.updateRecetas();
		//crearia una tabla con esta lista
	}

	@Override
	public void addObserver(SanidadObserver o) {
		this.observers.add(o);
		this.updateRecetas();
		o.onRegister(listaRecetas,listaMedicos,nombreUsuario);
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

	void onCrearReceta() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onCrearReceta(this.listaRecetas,this.listaMedicos,this.nombreUsuario);
		}
	}
	void onEliminarReceta() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onEliminarReceta(this.listaRecetas,this.listaMedicos,this.nombreUsuario);
		}
	}

	void onConsultarReceta() {
		this.updateRecetas();
		for(SanidadObserver o: this.observers) {
			o.onConsultarReceta(this.listaRecetas,this.listaMedicos,this.nombreUsuario);
		}
	}

	
	public boolean añadirReceta(int codigo, String medicamento, String dosis, String Nombremedico, String NombreAcampado, String comprado ,JFrame frame) {
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
			data.accumulate("NombreAcampado", NombreAcampado);
			data.accumulate("comprado", "Sin Adquirir");
			
			receta.accumulate("data", data);
			receta.accumulate("type", "receta");
			
			TReceta TReceta = (TReceta) this.factoriaTranserObjects.createInstance(receta);
			//SingletonControllerSanidad.getInstance().mostrarEliminarReceta(frame);(this.listaAverias.get(i));
			
			this.listaRecetas.add(TReceta);
			this.guardaReceta();
			this.onCrearReceta();
			
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
				    this.onEliminarReceta();
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
			    this.onConsultarReceta();
			}
		}
	}
	
	
}
