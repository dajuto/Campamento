package sanidad.Negocio;

import java.util.List;

import empleados.Negocio.TMedico;

public interface SanidadObserver {
	void onRegister(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario);
	void onCreateReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario);
	void onEliminarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario);
	//void onModificarReceta(List<TAveria> listaAverias, List<TEmpleadoMantenimiento> listaEmpleadosMantenimiento, String nombreUsuario);
	//void onActualizarListaEmpleadosMantenimiento(List<TAveria> listaAverias, List<TEmpleadoMantenimiento> listaEmpleadosMantenimiento, String nombreUsuario);
	//completar

}
