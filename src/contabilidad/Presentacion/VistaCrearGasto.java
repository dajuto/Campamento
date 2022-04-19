package contabilidad.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

<<<<<<< HEAD
<<<<<<< HEAD
import empleados.Negocio.TEmpleadoGestoria;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.TLimpieza;
=======
import empleados.Negocio.TEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;

>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
import empleados.Negocio.TEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;

>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.Gastos;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import javax.swing.DefaultComboBoxModel;

public class VistaCrearGasto extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto_txt;
	private JTextField fecha_txt;
	private JTextField importe_txt;
	private JTextField cuenta_txt;
	private JComboBox empleado;
	
	public VistaCrearGasto(JFrame frame) {
		setTitle("Añadir un Gasto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("A\u00F1adir Gasto");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 14, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lblConcepto = new JLabel("Concepto: ");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 101, 86, 25);
		getContentPane().add(lblConcepto);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 137, 69, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblFecha = new JLabel("Fecha de pago:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(25, 175, 116, 25);
		getContentPane().add(lblFecha);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 215, 97, 25);
		getContentPane().add(lblEmplead);
		
<<<<<<< HEAD
<<<<<<< HEAD
		empleado = new JComboBox(); //cambiaar (hay que poner condición de si es cuenta sueldos y salarios, puede escribir
		empleado.setBounds(121, 217, 116, 22);
		getContentPane().add(empleado);
		
=======
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
		empleado = new JComboBox<String>();
		empleado.setBounds(121, 217, 116, 22);
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Limpieza")) {
				empleado.addItem(e.getNombre());  // revisar
			}
		}
		getContentPane().add(empleado);
			
<<<<<<< HEAD
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
		concepto_txt = new JTextField();
		concepto_txt.setBounds(121, 103, 116, 22);
		getContentPane().add(concepto_txt);
		concepto_txt.setColumns(10);
		
		fecha_txt = new JTextField();
		fecha_txt.setBounds(151, 179, 116, 22);
		getContentPane().add(fecha_txt);
		fecha_txt.setColumns(10);
		
		importe_txt = new JTextField();
		importe_txt.setBounds(121, 141, 116, 22);
		getContentPane().add(importe_txt);
<<<<<<< HEAD
<<<<<<< HEAD
		importe_txt.setColumns(10);
=======
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
		importe_txt.setColumns(10);	
		
		if (!fecha_txt.getText().matches("Sueldos y salarios")) {
			empleado.setVisible(false);
			lblEmplead.setVisible(false);
		}
<<<<<<< HEAD
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fecha_txt.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
<<<<<<< HEAD
<<<<<<< HEAD
					if (importe_txt.getText().matches("\\d{2}:\\d{2}")) {
						String empleadoString = (String) empleado.getSelectedItem();
						//SingletonControllerGestoria.getInstance().añadirLimpieza(codigo_txt.getText(), lugar_txt.getText(), fecha_txt.getText(), hora_txt.getText(), empleadoString, getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "Formato de la hora incorrecto \n HH:MM", "Error", JOptionPane.ERROR_MESSAGE);	
					
					if (cuenta_txt.getText().matches("Sueldos y salarios")) {
						String empleadoString = (String) empleado.getSelectedItem();
						//SingletonControllerGestoria.getInstance().añadirLimpieza(codigo_txt.getText(), lugar_txt.getText(), fecha_txt.getText(), hora_txt.getText(), empleadoString, getFrame());
					}
					
				}
=======
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
					if (importe_txt.getText().matches("[0-9]*")) {
						String empleadoString = (String) empleado.getSelectedItem();
						SingletonControllerContabilidad.getInstance().añadirGasto(cuenta_txt.getText(), concepto_txt.getText(), importe_txt.getText(), fecha_txt.getText(), empleadoString, getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El importe debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);		
				}	
<<<<<<< HEAD
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
=======
>>>>>>> dc9ff1bf0eed17863b4fc8c4c14e9b1d793f2164
				else JOptionPane.showMessageDialog(atras, "Formato de la fecha incorrecto \n DD/MM/AAAA", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Crear.setBounds(266, 215, 97, 25);
		getContentPane().add(boton_Crear);
		
		JLabel lblCodigo = new JLabel("Cuenta de Gastos: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 148, 25);
		getContentPane().add(lblCodigo);
		
		cuenta_txt = new JTextField();
		cuenta_txt.setColumns(10);
		cuenta_txt.setBounds(183, 67, 116, 22);
		getContentPane().add(cuenta_txt);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onActualizar(List<Gastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	

}
