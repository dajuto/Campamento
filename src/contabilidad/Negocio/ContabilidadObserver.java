package contabilidad.Negocio;

import java.util.List;
public interface ContabilidadObserver {

	void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario);
	void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario);
	void onActualizar(List<Gastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario);
}



