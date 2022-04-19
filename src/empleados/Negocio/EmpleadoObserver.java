package empleados.Negocio;

import java.util.List;

import acampados.Negocio.TAcampado;

public interface EmpleadoObserver {

	void onRegister(List<TEmpleado> listaAcampados, String nombreUsuario);
	void onCreateEmpleado(List<TEmpleado> lista, String nombreUsuario);
	void onEliminarEmpleado(List<TEmpleado> lista, String nombreUsuario);
	void onModificarEmpleado(List<TEmpleado> listaEmpleados, String nombreUsuario);
}
