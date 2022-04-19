package empleados.Negocio;

import java.util.ArrayList;
import java.util.List;

public class TEmpleadoMantenimiento extends EmpleadoLimpieza{
	public TEmpleadoMantenimiento(String usuario, String contrasena, String nombre, String puesto, int salario, int horario, String vacaciones, List<String> listaAverias){
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.puesto = puesto;
		this.salario = salario;
		this.horario = horario;
		this.vacaciones = vacaciones;
		this.listaAverias = new ArrayList<String>(listaAverias);
	}
}

