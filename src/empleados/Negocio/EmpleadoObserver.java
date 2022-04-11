package empleados.Negocio;

import java.util.List;

public interface EmpleadoObserver {

	void onRegister(List<TEmpleado> lista, String nombreUsuario);
	void onCreateEmpleado(List<TEmpleado> lista, String nombreUsuario);
	void onEliminarEmpleado(List<TEmpleado> lista, String nombreUsuario);
	void onModificarEmpleado(List<TEmpleado> listaEmpleados, String nombreUsuario);
}
