package comedor.Negocio;


import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import comedor.Integracion.SingletonDaoMenu;
import launcher.Factory;
import launcher.Observable;

public class ServiAppMenu implements Observable<MenuObserver>{

	private List<MenuObserver> observers;
	private List<TMenu> listaMenu;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppMenu() {
		this.listaMenu = new ArrayList<TMenu>();
		this.observers = new ArrayList<MenuObserver>();
	}
	
	public void updateMenu() {
		this.listaMenu = SingletonDaoMenu.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}
	

	
	
	@Override
	public void addObserver(MenuObserver o) {
		this.observers.add(o);
		this.updateMenu();
		o.onRegister(listaMenu);
	}

	@Override
	public void removeObserver(MenuObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TMenu> getListaMenu() {
		this.updateMenu();
		return listaMenu;
	}

	public void guardaMenu() {
		
      SingletonDaoMenu.getInstance().escribeTodo(listaMenu);
	}
	
	void onCrearMenu() {
		this.updateMenu();
		for(MenuObserver o: this.observers) {
			o.onCrearMenu(this.listaMenu);
		}
	}
	
	void onEliminarMenu() {
		this.updateMenu();
		for(MenuObserver o: this.observers) {
			o.onEliminarMenu(this.listaMenu);
		}
	}

	
	void onConsultarMenu() {
		this.updateMenu();
		for(MenuObserver o: this.observers) {
			o.onConsultarMenu(this.listaMenu);
		}
	}
	
	
	
	public boolean crearMenu(String dia, String desayuno, String comida, String cena) {
		this.updateMenu();
		boolean puedo = true;
		for(TMenu ta: this.listaMenu) {
			if(ta.dia == dia) {
				puedo = false;
			}
		}
		if(puedo) {
			JSONObject comedor = new JSONObject();
			
			JSONObject data = new JSONObject();
			data.accumulate("Dia", dia);
			data.accumulate("Desayuno", desayuno);
			data.accumulate("Comida", comida);
			data.accumulate("Cena", cena);
			
			comedor.accumulate("data", data);
			comedor.accumulate("type", "menu");
			
			TMenu ta = (TMenu) this.factoriaTranserObjects.createInstance(comedor);
			this.listaMenu.add(ta);
			this.guardaMenu();
		    this.onCrearMenu();
		    return true;
		}
		else {
			return false;
		}
	}
	
	
	
	public boolean eliminarMenu(Frame ventanaListaMenu, String dia) {
		boolean actividad = true;
		for(int i = 0; i < this.listaMenu.size(); i++) {
			if(this.listaMenu.get(i).getDia() == dia) {
					this.listaMenu.remove(i);
					this.guardaMenu();
				    this.onEliminarMenu();
				    i--;
				}
				
		}
		return actividad;
	}
	
	public void consultarMenu(String dia) {
		for(TMenu ta: this.listaMenu) {
			if(ta.dia == dia) {
				if(ta.dia.equals("Sin Establecer")) {
					ta.dia = "Establecido";
				}
				else {
					ta.dia = "Sin Establecer";
				}
				this.guardaMenu();
			    this.onConsultarMenu();
			}
		}
	}
	
	
	
}

	
	


