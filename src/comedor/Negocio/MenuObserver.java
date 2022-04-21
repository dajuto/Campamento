package comedor.negocio;

import java.util.List;

public interface MenuObserver {

	void onCrearMenu(List<TMenu> lista);
	void onModificarMenu(List<TMenu> lista);
	void onEliminarMenu(List<TMenu> lista);
	void onConsultarMenu(List<TMenu> lista);
	
}
