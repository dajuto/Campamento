package sanidad.Negocio;

import java.util.List;

import empleados.Negocio.TMedico;

public interface SanidadObserver {
	void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas,List<TMedico> listaMedicos, String nombreUsuario);
	
	void onEliminar(List<TReceta> listaRecetas,List<TCita> listaCitas ,List<TMedico> listaMedicos, String nombreUsuario);
	
	void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas ,List<TMedico> listaMedicos, String nombreUsuario);
	
	void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos, String nombreUsuario);
	
	
	
	

}
