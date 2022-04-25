package acampados.Negocio;

import java.util.List;

public interface AcampadoObserver {
<<<<<<< HEAD
	void onRegister(List<TAcampado> lista);
	void onCreateAcampado(List<TAcampado> lista);
	void onEliminarAcampado(List<TAcampado> lista);
	void onModificarAcampado(List<TAcampado> listaAverias);
=======
	void onRegister(List<TAcampado> lista, String Usuario/*mas cosas*/);
	void onCreateAcampado(List<TAcampado> lista,String Usuario);
	void onEliminarAcampado(List<TAcampado> lista, String Usuario);
	void onModificarAcampado(List<TAcampado> listaAverias ,String Usuario);
>>>>>>> f1b19b8eee9dc9f7ad743e45c431d8d9e2c3f686
}
