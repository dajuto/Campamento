package acampados.Negocio;

import java.util.List;

public interface AcampadoObserver {
	void onRegister(List<TAcampado> lista);
	void onCreateAcampado(List<TAcampado> lista);
	void onEliminarAcampado(List<TAcampado> lista);
	void onModificarAcampado(List<TAcampado> listaAverias);
	void onRegister(List<TAcampado> lista, String Usuario/*mas cosas*/);
	void onCreateAcampado(List<TAcampado> lista,String Usuario);
	void onEliminarAcampado(List<TAcampado> lista, String Usuario);
	void onModificarAcampado(List<TAcampado> listaAverias ,String Usuario);

}
