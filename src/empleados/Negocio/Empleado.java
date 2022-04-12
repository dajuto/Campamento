package empleados.Negocio;

public abstract class Empleado {
	protected int codigo;
	protected String nombre;
	protected String puesto;
	protected int salario;
	protected int horario;
	protected String vacaciones;
	
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
	
	public int getUsuario() {
		return codigo;
	}
	
	public String getPuesto() {
		return puesto;
	}

}
