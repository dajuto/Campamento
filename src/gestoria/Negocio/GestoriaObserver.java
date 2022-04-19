package gestoria.Negocio;

import java.util.List;

import empleados.Negocio.TEmpleadoLimpieza;

public interface GestoriaObserver {
	void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones, List <TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario);
	void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones, List <TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario);
	void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones, List <TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario);
	void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones, List <TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario);
	//void onActualizarListaEmpleadosLimpieza(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones, List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario);
	//completar
}
