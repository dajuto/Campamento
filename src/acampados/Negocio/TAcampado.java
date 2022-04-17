package acampados.Negocio;

import java.util.List;

public class TAcampado extends Acampado{
public TAcampado(String usuario, String contrasena, String nombre, String apellidos, int dni, String email, String salud, String habitacion, boolean pagado) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.nombre=nombre;
		this.apellidos = apellidos;
		this.dni=dni;
		this.salud=salud;
		this.email=email;
		this.habitacion = habitacion;
		//this.listaactividades = listaactividades;
		this.pagado = pagado;	
	}

}