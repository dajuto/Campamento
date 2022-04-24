package comedor.negocio;

import java.util.ArrayList;
import java.util.List;

import launcher.Factory;
import launcher.Observable;

public class ServiAppMenu implements Observable<Menu>{

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
		
	}
	
	@Override
	public void addObserver(Menu o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Menu o) {
		// TODO Auto-generated method stub
		
	}


}
