package gestoria.Negocio;

import empleados.Negocio.Empleado;

public class TInstalacion extends Instalacion{
	public TInstalacion(String codigo, String nombre, int superficie, int precio, boolean pagado, boolean actividades){
		this.codigo = codigo;
		this.nombre = nombre;
		this.superficie = superficie;
		this.precio = precio;
		this.pagado = pagado;
		this.puedeActividades = actividades;
	}
}
