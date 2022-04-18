package empleados.Negocio;

public class TGestor extends Gestor{
	public TGestor(String usuario, String contrasena, String nombre, String puesto, int salario, int horario, String vacaciones){
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
	}
}

