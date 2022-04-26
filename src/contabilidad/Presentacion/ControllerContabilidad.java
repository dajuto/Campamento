package contabilidad.Presentacion;

import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import acampadosPresentacion.SingletonControllerAcampado;
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.SingletonServiAppContabilidad;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;
import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.SingletonServiAppGestoria;
import gestoria.Negocio.TLimpieza;
import gestoria.Presentacion.VistaMenuAcampado;
import gestoria.Presentacion.VistaMenuInstalacionesGestor;
import launcher.Factory;

public class ControllerContabilidad {
	
	public void registraUsuario(String text, char[] password) {
		SingletonServiAppGestoria.getInstance().registraUsuario(text, password);
	}

	public void registraFactoria(Factory<Object> objetosFactory) {
		SingletonServiAppContabilidad.getInstance().registrarFactoria(objetosFactory);
	}
	
	public void menuContabilidad(JFrame frame) {  //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaMenuContabilidad(frame);
			}
		});
	}

	public void menuGastos(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGastosContabilidad(frame);
			}
		});
	}

	public void menuIngresos(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaIngresosContabilidad(frame);
			}
		});
	}
	
	public void menuRendimiento(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaRendimientoContabilidad(frame);
			}
		});
	}
		public void mostrarGastos(JFrame frame) { //hecha
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VistaVerGastos(frame);
			    }
			});
		}
		
		public void mostrarIngresos(JFrame frame) { //hecha
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new VistaVerIngresos(frame);
			    }
			});
		}
	
	public void mostrarCrearGasto(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearGasto(frame);
			}
		});
	}
	
	public void mostrarCrearIngreso(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaCrearIngreso(frame);
			}
		});
	}
	
	public void mostrarEliminarGastos(JFrame frame) {  //nueva
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarGasto(frame);
			}
		});
	}
	
	public void mostrarEliminarIngresos(JFrame frame) {  //nueva
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEliminarIngreso(frame);
			}
		});
	}
	
	public void mostrarModificarIngresos(JFrame frame) {  //nueva
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarIngresos(frame);
			}
		});
	}
	
	public void mostrarModificarGastos(JFrame frame) {  //nueva
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaModificarGasto(frame);
			}
		});
	}
	
	//acampado
	public void estadoCuentasAcampado(JFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaContabilidadAcampado(frame);
			}
		});
	}
	//acampado
	public String getAcampado() {
		String n =SingletonControllerAcampado.getInstance().getAcampado();
		return n;
	}
	
	public void menuVerEstado(JFrame frame) { //hecha
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaEstadoAcampado(frame);
			}
		});
	}
	
	
	public void eliminarGasto(JFrame frame, String codigo) {
		SingletonServiAppContabilidad.getInstance().eliminarGasto(frame, codigo);
	}
	
	public void eliminarIngreso(JFrame frame, String codigo) {
		SingletonServiAppContabilidad.getInstance().eliminarIngreso(frame, codigo);
	}
	
	
	public void modificarGasto(String cuenta, String concepto, String importe, String fecha, String empleado, Boolean contabilizada, String numeroFactura,   JFrame frame) {
		SingletonServiAppContabilidad.getInstance().modificarGasto(cuenta, concepto, importe, fecha, empleado, contabilizada, numeroFactura,  frame);
		frame.setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaGastosContabilidad(frame);
			}
		});
	}
	
	
	public void modificarIngreso(String cuenta, String concepto, String importe, String fecha, String nombreAcam, String DniAcam, Boolean contabilizada, String numeroFactura,  JFrame frame) {
		SingletonServiAppContabilidad.getInstance().modificarIngreso(cuenta, concepto, importe, fecha, nombreAcam, DniAcam, contabilizada, numeroFactura,  frame);
		frame.setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VistaIngresosContabilidad(frame);
			}
		});
	}
	
	
	//ADRIANA
	public void añadirGasto(String cuenta, String concepto, String importe, String fecha, String empleado, Boolean contabilizada, String numeroFactura,  JFrame frame) {
		boolean existe = SingletonServiAppContabilidad.getInstance().añadirGasto(cuenta, concepto, importe, fecha, empleado, contabilizada, numeroFactura,  frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaGastosContabilidad(frame); 
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Codigo no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
	

	public void añadirIngreso(String cuenta, String concepto, String importe, String fecha, String nombreAcam, String dniAcam, Boolean contabilizada, String numeroFactura,  JFrame frame) {
		boolean existe = SingletonServiAppContabilidad.getInstance().añadirIngreso(cuenta, concepto, importe, fecha, nombreAcam, dniAcam, contabilizada, numeroFactura,  frame);
		if (existe) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					frame.setVisible(false);
					new VistaIngresosContabilidad(frame);  
				}
			});
		}
		else {
			JOptionPane.showMessageDialog(frame, "Codigo no disponible", "Error", JOptionPane.ERROR_MESSAGE);	
		}
	}
		
	public List<TGastos> getListaGastos() {
		List<TGastos> listaGastos = SingletonServiAppContabilidad.getInstance().getListaGastos();
		return listaGastos;
	}
	
	public List<TIngresos> getListaIngresos() {
		List<TIngresos> listaIngresos = SingletonServiAppContabilidad.getInstance().getListaIngresos();
		return listaIngresos;
	}
	
	public void addObserver(ContabilidadObserver vista) {  //hecha
		SingletonServiAppContabilidad.getInstance().addObserver(vista);	
	}

	public List<TEmpleado> getListaEmpleados() {
		return SingletonControllerEmpleado.getInstance().getListaEmpleados();
	}
}



























