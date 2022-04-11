package gestoria.Negocio;

public class TLimpieza extends Limpieza{
	public TLimpieza(int codigo, String lugar, String fecha, String hora){
		this.codigo = codigo;
		this.lugar = lugar;
		this.fecha = fecha;
		this.hora = hora;
		//this.empleadoEncargado = empleadoEncargado; AÑADIR EN EL CONSTRUCTOR TAMBIEN
	}
}
