package acampados.Negocio;

import java.util.List;

public interface AcampadoObserver {
	void onRegister(List<TAcampado> lista/*mas cosas*/);
	void onCreateEstudiante(List<TAcampado> lista);
	void onEliminarEstudiante(List<TAcampado> lista);
	void onModificarEstudiante(List<TAcampado> listaAverias);
}
