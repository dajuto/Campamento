package contabilidad.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;



import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Presentacion.SingletonControllerGestoria;

import empleados.Negocio.TEmpleado;
import gestoria.Presentacion.SingletonControllerGestoria;


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
	private JComboBox<String> cuenta_txt;
	private JComboBox<String> empleado_txt;
	List<TGastos> listaGastos;
	List<TEmpleado> listaEmpleados;
	
	public VistaCrearGasto(JFrame frame) {
		setTitle("Añadir un Gasto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		listaEmpleados = SingletonControllerEmpleado.getInstance().getListaEmpleados();
		
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
		labcrear.setBounds(25, 20, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lblCodigo = new JLabel("Cuenta de Gasto: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 66, 148, 25);
		getContentPane().add(lblCodigo);
		
		JLabel lblConcepto = new JLabel("Concepto: ");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 101, 86, 25);
		getContentPane().add(lblConcepto);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 137, 69, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblFecha = new JLabel("Fecha contable:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(25, 175, 116, 25);
		getContentPane().add(lblFecha);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 215, 97, 25);
		getContentPane().add(lblEmplead);
			
		concepto_txt = new JTextField();
		concepto_txt.setBounds(121, 103, 116, 22);
		getContentPane().add(concepto_txt);
		concepto_txt.setColumns(10);
		
		cuenta_txt = new JComboBox<String>();
		cuenta_txt.setBounds(183, 67, 116, 22);
		getContentPane().add(cuenta_txt);
		for(TGastos e: listaGastos) {
			cuenta_txt.addItem(e.getTipo());
		}
		
		fecha_txt = new JTextField();
		fecha_txt.setBounds(151, 179, 116, 22);
		getContentPane().add(fecha_txt);
		fecha_txt.setColumns(10);
		
		importe_txt = new JTextField();
		importe_txt.setBounds(121, 141, 116, 22);
		getContentPane().add(importe_txt);
		importe_txt.setColumns(10);
		
		empleado_txt = new JComboBox<String>();
		empleado_txt.setBounds(121, 216, 116, 22);
		getContentPane().add(empleado_txt);
		for(TEmpleado e: listaEmpleados) {
			empleado_txt.addItem(e.getNombre());
		}
		
		if (!((String) cuenta_txt.getSelectedItem()).matches("Sueldos y Salarios")) {
			
			empleado_txt.setVisible(false);
			lblEmplead.setVisible(false);	
		}
		
		cuenta_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!((String) cuenta_txt.getSelectedItem()).matches("Sueldos y Salarios")) {
					
					empleado_txt.setVisible(false);
					lblEmplead.setVisible(false);	
				}else {	
					empleado_txt.setVisible(true);
					lblEmplead.setVisible(true);	
				}	
			}
		});
		
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empleado = "";
				if (((String) cuenta_txt.getSelectedItem()).matches("Sueldos y Salarios")) {
					empleado = (String) empleado_txt.getSelectedItem();
				}
				
				if (fecha_txt.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
					
					if (importe_txt.getText().matches("[0-9]*")) {
						String cuenta = (String) cuenta_txt.getSelectedItem();
						SingletonControllerContabilidad.getInstance().añadirGasto(cuenta, concepto_txt.getText(), importe_txt.getText(), fecha_txt.getText(), empleado, getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El importe debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);	
				}	
				else JOptionPane.showMessageDialog(atras, "Formato de la fecha incorrecto \n DD/MM/AAAA", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Crear.setBounds(266, 215, 97, 25);
		getContentPane().add(boton_Crear);
		
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
	public void onActualizar(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
}
