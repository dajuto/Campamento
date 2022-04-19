package acampados.Negocio;

import java.util.List;

public interface AcampadoObserver {
	void onRegister(List<TAcampado> lista/*mas cosas*/);
	void onCreateAcampado(List<TAcampado> lista);
	void onEliminarAcampado(List<TAcampado> lista);
	void onModificarAcampado(List<TAcampado> listaAverias);
}
