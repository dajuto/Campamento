package acampados.Negocio;

import java.util.List;

public class TAcampado extends Acampado{
public TAcampado(String usuario, String contrasena, String nombre, String apellidos, String dni, String email,int edad, int telefono, String salud, String habitacion, List<String> listaActividades, boolean pagado) {
		this.usuario=usuario;
		this.contrasena=contrasena;
		this.nombre=nombre;
		this.apellidos = apellidos;
		this.dni=dni;
		this.salud=salud;
		this.email=email;
		this.edad=edad;
		this.telefono=telefono;
		this.habitacion = habitacion;
		this.listaactividades = listaActividades;
		this.pagado = pagado;	
	}

}