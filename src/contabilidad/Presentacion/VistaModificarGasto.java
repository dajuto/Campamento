package contabilidad.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
import empleados.Presentacion.SingletonControllerEmpleado;
import gestoria.Negocio.GestoriaObserver;
import gestoria.Negocio.TInstalacion;
import gestoria.Negocio.TLimpieza;
import gestoria.Negocio.TMantenimiento;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import contabilidad.Negocio.TGastos;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class VistaModificarGasto extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField nombre;
	private JTextField importe;
	private JTextField fecha;
	private JTextField empleadoNombre; 
	private String importeString;
	private JComboBox<String> concepto;
	private JCheckBox contabilizada;
	List<TGastos> listaGastos; 
	List<TEmpleado> listaEmpleados;
	
	public VistaModificarGasto(JFrame frame) {
		setTitle("Modificar gasto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,350);
		
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		listaEmpleados = SingletonControllerEmpleado.getInstance().getListaEmpleados();
		
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atr�s");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 265, 97, 25);
		getContentPane().add(boton_Atras);
		
			
		JLabel labmodificar = new JLabel("Seleccione un gasto");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblNombre = new JLabel("Cuenta de Gasto:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(25, 101, 127, 25);
		getContentPane().add(lblNombre);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 137, 84, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblFecha = new JLabel("Fecha contable:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(25, 175, 116, 25);
		getContentPane().add(lblFecha);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 222, 97, 25);
		getContentPane().add(lblEmplead);
		
		
		nombre = new JTextField();
		nombre.setBounds(162, 105, 116, 22);
		nombre.setText(listaGastos.get(0).getTipo()); //cuenta de gasto
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		importe = new JTextField();
		importe.setBounds(121, 139, 116, 22);
		importeString = Integer.toString(listaGastos.get(0).getImporte());
		importe.setText(importeString);
		getContentPane().add(importe);
		importe.setColumns(10);
		
		fecha = new JTextField();
		fecha.setBounds(162, 179, 116, 22);
		fecha.setText(listaGastos.get(0).getFecha());
		getContentPane().add(fecha);
		fecha.setColumns(10);
		
		empleadoNombre = new JTextField();
		empleadoNombre.setBounds(121, 226, 116, 22);
		empleadoNombre.setText(listaGastos.get(0).getNombre());
		getContentPane().add(empleadoNombre);
		empleadoNombre.setColumns(11);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (importe.getText().matches("[0-9]*")) {
					if (fecha.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
			
						SingletonControllerContabilidad.getInstance().modificarGasto(nombre.getText(), concepto.getSelectedItem().toString(), importe.getText(), fecha.getText(),empleadoNombre.getText(),  contabilizada.isSelected(), getFrame());
					}
					else JOptionPane.showMessageDialog(atras, "El precio tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
				}
				else JOptionPane.showMessageDialog(atras, "La superficie tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(264, 265, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 63, 84, 25);
		getContentPane().add(lblConcepto);
		
		concepto = new JComboBox<String>();
		concepto.setBounds(121, 63, 116, 22);
		for(TGastos cod: this.listaGastos) {	
				concepto.addItem(cod.getConcepto());
			
		}
		
		
					importe.setEnabled(false); 
					fecha.setEnabled(false); 
					empleadoNombre.setEnabled(false); 	
			
		
		concepto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TGastos cod: listaGastos) {
					if (cod.getConcepto().equals(concepto.getSelectedItem().toString())) {
						if (cod.isContabilizada()) { //solo se pueden modificar el concepto y la cuenta de gasto
							contabilizada.setEnabled(false);
							importe.setEnabled(false); 
							fecha.setEnabled(false); 
							empleadoNombre.setEnabled(false); 	
						}
						else {
							contabilizada.setEnabled(true);
							importe.setEnabled(true); 
							fecha.setEnabled(true); 
							empleadoNombre.setEnabled(true); 	
						}
						
						importeString = Integer.toString(cod.getImporte());
						importe.setText(importeString);
						empleadoNombre.setText(cod.getNombre());
						nombre.setText(cod.getTipo());
						fecha.setText(cod.getFecha());
			
					}
				}
			}
		});
		getContentPane().add(concepto);
			
		contabilizada = new JCheckBox("Marcar para contabilizar un gasto");
		contabilizada.setBounds(318, 224, 106, 25);
		contabilizada.setSelected(listaGastos.get(0).isContabilizada());
		getContentPane().add(contabilizada);
		if (listaGastos.get(0).isContabilizada()) {
			contabilizada.setEnabled(false);
		}

		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
}
