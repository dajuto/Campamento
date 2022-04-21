package contabilidad.Negocio;


import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import contabilidad.Integracion.SingletonDaoGastos;
import contabilidad.Integracion.SingletonDaoIngresos;
import launcher.Factory;
import launcher.Observable;

public class ServiAppContabilidad implements Observable<ContabilidadObserver>{
	private List<ContabilidadObserver> observers;
	private List <TGastos> listaGastos; 
	private List<TIngresos> listaIngresos;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppContabilidad() {
		this.listaGastos = new ArrayList<TGastos>();
		this.listaIngresos= new ArrayList<TIngresos>();
		this.observers = new ArrayList<ContabilidadObserver>();
	}
	

	public void registrarFactoria(Factory<Object> objetosFactory) {  // la tenia alvaro
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}

	@Override
	public void addObserver(ContabilidadObserver o) {  //por ejemplo se usa en GastosTableModel e ingresosTableModel
		this.observers.add(o);
		this.updateGastos();
		this.updateIngresos();
		o.onRegister(listaGastos, listaIngresos, nombreUsuario);
	}
	
	
	@Override
	public void removeObserver(ContabilidadObserver o) {
		this.observers.remove(o);
	}
	

	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	
	public List<TGastos> getListaGastos() {
		this.updateGastos();
		return listaGastos;
	}

	public List<TIngresos> getListaIngresos() {
		this.updateIngresos();
		return listaIngresos;
	}
	
		public void updateGastos() {
			this.listaGastos = SingletonDaoGastos.getInstance().leeTodo(this.factoriaTranserObjects);
		}
		
		
		public void guardaGastos() {
	        SingletonDaoGastos.getInstance().escribeTodo(this.listaGastos);
		}
	 
	public boolean añadirGasto(String cuenta, String concepto, String importe, String fecha, String empleado, JFrame frame) {
		
		this.updateGastos();
		
	
		JSONObject gastos = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", cuenta);
		data.accumulate("Concepto", concepto);
		data.accumulate("Importe", importe);
		data.accumulate("Fecha de pago", fecha);
		data.accumulate("Empleado", empleado);
		
		gastos.accumulate("data", data);
		gastos.accumulate("type", "gastos");
		
		TGastos tgastos = (TGastos) this.factoriaTranserObjects.createInstance(gastos);
		this.listaGastos.add(tgastos);
		this.guardaGastos();
		this.updateGastos();
		
		return true;
	}
	
	
	// ++++++++++++++INGRESOS ++++++++++++
	public void updateIngresos() {
		this.listaIngresos = SingletonDaoIngresos.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	public void guardaIngresos() {
        SingletonDaoIngresos.getInstance().escribeTodo(this.listaIngresos);
	}	
	
    public boolean añadirIngreso(String cuenta, String concepto, String importe, String fecha, String nombreAcampado, String dniAcampado, boolean contabilizada,  JFrame frame) {
		
		this.updateIngresos();
		
		JSONObject ingresos = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", cuenta);
		data.accumulate("Concepto", concepto);
		data.accumulate("Importe", importe);
		data.accumulate("Fecha contable", fecha);
		JSONObject acampado = new JSONObject();
		acampado.accumulate("Nombre", nombreAcampado);
		acampado.accumulate("DNI", dniAcampado); 
		data.accumulate("Acampado", acampado);
		data.accumulate("Contabilizada", "No");
	
		ingresos.accumulate("data", data);
		ingresos.accumulate("type", "ingresos");
		
		TIngresos tingresos = (TIngresos) this.factoriaTranserObjects.createInstance(ingresos);
		this.listaIngresos.add(tingresos);
		this.guardaIngresos();
		this.updateIngresos();

		
		return true;
	}

    

}
