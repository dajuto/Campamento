package gestoria.Negocio;

import java.util.List;

public interface LimpiezaObserver {
	void onRegister(List<TLimpieza> listaLimpieza, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario);
	void onCreateAveria(List<TAveria> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosMantenimiento, String nombreUsuario);
	void onEliminarAveria(List<TAveria> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosMantenimiento, String nombreUsuario);
	void onModificarAveria(List<TAveria> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosMantenimiento, String nombreUsuario);
	void onActualizarListaEmpleadosMantenimiento(List<TAveria> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosMantenimiento, String nombreUsuario);
	//completar
}
