package gestoria.Negocio;

import empleados.Negocio.Empleado;
import empleados.Negocio.TEmpleadoLimpieza;

public class TLimpieza extends Limpieza{
	public TLimpieza(String codigo, String lugar, String dia, String hora, String empleadoEncargado){
		this.codigo = codigo;
		this.lugar = lugar;
		this.dia = dia;
		this.hora = hora;
		this.empleadoEncargado = empleadoEncargado;
	}
}
