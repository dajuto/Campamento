package gestoria.Negocio;

import java.util.List;

import empleados.Negocio.TEmpleadoGestoria;

public interface LimpiezaObserver {
	void onRegister(List<TLimpieza> listaLimpieza, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	void onCreateLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	void onEliminarLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	void onModificarLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	void onActualizarListaEmpleadosLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	//completar
}
