package actividades.Negocio;

import java.util.List;

public interface ActividadObserver {

	void onRegister(List<TActividad> lista);
	void onCreateActividad(List<TActividad> lista);
	void onEliminarActividad(List<TActividad> lista);
	
}
