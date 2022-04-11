package acampados.Negocio;

import java.util.List;

public class TAcampado extends Acampado{
public TAcampado(String nombre, String usuario, boolean isConfinado, String habitacion, List<String> listaactividades, boolean pagado) {
		this.nombre=nombre;
		this.confinado = isConfinado;
		this.usuario=usuario;
		this.habitacion = habitacion;
		this.listaactividades = listaactividades;
		this.pagado = pagado;
		
	}

}