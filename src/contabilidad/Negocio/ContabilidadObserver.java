package contabilidad.Negocio;

import java.util.List;
public interface ContabilidadObserver {

	void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario);
	void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario);
	void onActualizar(List<Gastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario);
}



