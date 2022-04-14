package gestoria.Negocio;

import empleados.Negocio.Empleado;

public class TLimpieza extends Limpieza{
	public TLimpieza(int codigo, String lugar, String fecha, String hora, String empleadoEncargado){
		this.codigo = codigo;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		this.empleadoEncargado = empleadoEncargado;
	}
}
