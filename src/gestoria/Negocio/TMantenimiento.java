package gestoria.Negocio;

import empleados.Negocio.Empleado;
import empleados.Negocio.TEmpleadoLimpieza;

public class TMantenimiento extends Mantenimiento{
	public TMantenimiento(String codigo, String nombre, String descripcion, String lugar, int coste, String empleado, String estado){
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.coste = coste;
		this.empleado = empleado;
		this.estado = estado;
	}
}
