package comedor.negocio;

import java.util.List;

public interface MenuObserver {

	void onCrearMenu(List<TMenu> listaMenu);
	void onModificarMenu(List<TMenu> listaMenu);
	void onEliminarMenu(List<TMenu> listaMenu);
	void onConsultarMenu(List<TMenu> listaMenu);
	
}
