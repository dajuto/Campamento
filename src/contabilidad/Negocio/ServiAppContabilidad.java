package contabilidad.Negocio;


import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.json.JSONObject;

import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Integracion.SingletonDaoLimpieza;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
import gestoria.Presentacion.SingletonControllerGestoria;
import launcher.Factory;
import launcher.Observable;

public class ServiAppContabilidad implements Observable<ContabilidadObserver>{
	private List<ContabilidadObserver> observers;
	private List <TGastos> listaGastos; 
	private List<TIngresos> listaIngresos;
	private List<TEmpleadoGestoria> listaEmpleadosLimpieza;
	private Factory<Object> factoriaTranserObjects;
	private String nombreUsuario;
	private char[] contrasenaUsuario;
	
	public ServiAppContabilidad() {
		this.listaLimpieza = new ArrayList<TLimpieza>();
		this.listaEmpleadosLimpieza = new ArrayList<TEmpleadoGestoria>();
		this.observers = new ArrayList<ContabilidadObserver>();
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public void updateLimpieza() {
		this.listaLimpieza = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
	}
=======
	
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
	
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
	
	public void registrarFactoria(Factory<Object> objetosFactory) {
		this.factoriaTranserObjects = objetosFactory;
	}

	public void registraUsuario(String text, char[] password) {
		this.nombreUsuario = text;
		this.contrasenaUsuario = password;
	}

	public void mostrarListaLimpiezaEmpleado(String nombreEmpleado) {
		this.updateLimpieza();
	}

	@Override
	public void addObserver(ContabilidadObserver o) {
		this.observers.add(o);
		this.updateLimpieza();
		//TODO this.updateEmpleadosLimpieza();
		o.onRegister(listaLimpieza, listaEmpleadosLimpieza, nombreUsuario);
	}

	@Override
	public void removeObserver(LimpiezaObserver o) {
		this.observers.remove(o);
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}

	public List<TLimpieza> getListaLimpiezaGestor() {	
		this.updateLimpieza();
		return listaLimpieza;
	}
	
	public void guardaLimpieza() {
        SingletonDaoLimpieza.getInstance().escribeTodo(this.listaLimpieza);
	}

<<<<<<< HEAD
<<<<<<< HEAD
	public boolean aņadirLimpieza(String codigo, String lugar, String fecha, String hora, String empleado, JFrame frame) {
		this.updateLimpieza();
		for(TLimpieza ta: this.listaLimpieza) {
			if(ta.codigo.equals(codigo)) {
				return false;
			}
		}
		JSONObject limpieza = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Codigo", codigo);
		data.accumulate("Lugar", lugar);
		data.accumulate("Fecha", fecha);
		data.accumulate("Hora", hora);
		data.accumulate("Empleado", empleado);
		
		limpieza.accumulate("data", data);
		limpieza.accumulate("type", "limpieza");
		
		TLimpieza tLimpieza = (TLimpieza) this.factoriaTranserObjects.createInstance(limpieza);
		this.listaLimpieza.add(tLimpieza);
		this.guardaLimpieza();
		this.updateLimpieza();
=======
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
	
	  //ALVARO
		//public void updateLimpieza() {
			//this.listaLimpieza = SingletonDaoLimpieza.getInstance().leeTodo(this.factoriaTranserObjects);
		//}
		
		 //adri 
		
		public void updateGastos() {
			this.listaGastos = SingletonDaoGastos.getInstance().leeTodo(this.factoriaTranserObjects);
		}
		
		//alvaro
		//public void guardaLimpieza() {
	        //SingletonDaoLimpieza.getInstance().escribeTodo(this.listaLimpieza);
		//}
         
		//adri
		public void guardaGastos() {
	        SingletonDaoGastos.getInstance().escribeTodo(this.listaGastos);
		}
	//funcion adri 
	public boolean aņadirGasto(String cuenta, String concepto, String importe, String fecha, String empleado, JFrame frame) {
		
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
		this.listaGastos = SingletonDaoIngresos.getInstance().leeTodo(this.factoriaTranserObjects);
	}
	
	public void guardaIngresos() {
        SingletonDaoIngresos.getInstance().escribeTodo(this.listaIngresos);
	}	
	
    public boolean aņadirIngreso(String cuenta, String concepto, String importe, String fecha, String empleado, JFrame frame) {
		
		this.updateGastos();
		
	
		JSONObject ingresos = new JSONObject();
		JSONObject data = new JSONObject();
		data.accumulate("Tipo", cuenta);
		data.accumulate("Concepto", concepto);
		data.accumulate("Importe", importe);
		data.accumulate("Fecha de pago", fecha);
		data.accumulate("Empleado", empleado);
		
		ingresos.accumulate("data", data);
		ingresos.accumulate("type", "ingresos");
		
		TIngresos tingresos = (TIngresos) this.factoriaTranserObjects.createInstance(ingresos);
		this.listaIngresos.add(tingresos);
		this.guardaIngresos();
		this.updateIngresos();
<<<<<<< HEAD
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
		
		return true;
	}


<<<<<<< HEAD
<<<<<<< HEAD
	
=======
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
	@Override
	public void removeObserver(ContabilidadObserver o) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< HEAD
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
}
