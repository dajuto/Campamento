package gestoria.Negocio;

import empleados.Negocio.Empleado;
import empleados.Negocio.TEmpleadoLimpieza;

public class TLimpieza extends Limpieza{
	public TLimpieza(String codigo, String lugar, String fecha, String hora, TEmpleadoLimpieza empleadoEncargado){
		this.codigo = codigo;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		this.empleadoEncargado = empleadoEncargado;
	}
}
