package comedor.Negocio;

import java.util.List;

public interface MenuObserver {
	void onRegister(List<TMenu> listaMenu);
	void onCrearMenu(List<TMenu> listaMenu);
	void onEliminarMenu(List<TMenu> listaMenu);
	void onConsultarMenu(List<TMenu> listaMenu);
}
