package empleados.Negocio;

import org.json.JSONObject;

public abstract class Empleado {
	protected String usuario;
	protected String contrasena;
	protected String nombre;
	protected String puesto;
	protected int salario;
	protected int horario;
	protected String vacaciones;
	protected JSONObject trabajo;
	
	public JSONObject getTrabajo() {
		return trabajo;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public int getSalario() {
		return salario;
	}

	public int getHorario() {
		return horario;
	}

	public String getVacaciones() {
		return vacaciones;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getPuesto() {
		return puesto;
	}

}
