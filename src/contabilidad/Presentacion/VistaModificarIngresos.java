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

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import contabilidad.Negocio.TIngresos;


import javax.swing.JCheckBox;


//prueba

import java.text.SimpleDateFormat;
import java.util.Date;

public class VistaModificarIngresos extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto;
	private JTextField importe;
	private String dniAcamp;
	private JComboBox<String> acampadoNombre;
	private String importeString;
	private JComboBox<String> cuenta;
	private JCheckBox contabilizada;
	List<TIngresos> listaIngresos; 
	List<TAcampado> listaAcampados;
	private String acampado; 
	private String fecha;
	
	
	public VistaModificarIngresos(JFrame frame) {
		setTitle("Modificar ingreso");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,350);
		
		listaIngresos = SingletonControllerContabilidad.getInstance().getListaIngresos();
		listaAcampados = SingletonControllerAcampado.getInstance().getListaAcampados();
	        
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 265, 97, 25);
		getContentPane().add(boton_Atras);
		
			
		JLabel labmodificar = new JLabel("Seleccione un ingreso");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 24, 228, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblCuenta = new JLabel("Cuenta de ingresos:");
		lblCuenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuenta.setBounds(25, 79, 143, 25);
		getContentPane().add(lblCuenta);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 174, 84, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblEmplead = new JLabel("Nombre acampado:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmplead.setBounds(25, 222, 143, 25);
		getContentPane().add(lblEmplead);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 130, 84, 25);
		getContentPane().add(lblConcepto);
		
		concepto = new JTextField();
		concepto.setBounds(121, 134, 116, 22);
		concepto.setText(listaIngresos.get(0).getConcepto()); //concepto
		getContentPane().add(concepto);
		concepto.setColumns(10);
		
		importe = new JTextField();
		importe.setBounds(121, 178, 116, 22);
		importeString = Integer.toString(listaIngresos.get(0).getImporte());
		importe.setText(importeString);
		getContentPane().add(importe);
		importe.setColumns(10);
	
		acampadoNombre =  new JComboBox<String>();
		acampadoNombre.setBounds(162, 225, 116, 22);
		acampadoNombre.setSelectedItem(listaIngresos.get(0).getNombreAcampado());
		getContentPane().add(acampadoNombre);
		for(TAcampado e: listaAcampados) {
			if(!e.isPagado()) {
				acampadoNombre.addItem(e.getNombreCompleto());  //solo cogemos el acampado que no haya pagado
			}	
		}
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (importe.getText().matches("[0-9]*")) {
						 if(!((String) cuenta.getSelectedItem()).matches("Ventas")) {	
								acampado = "";
								
							}else {
							    acampado = (String) acampadoNombre.getSelectedItem();
							}
							//estoy cogiendo el dni del acampado seleccionado 
							for(TAcampado y: listaAcampados) {		
								if(acampado.matches(y.getNombreCompleto())) {
									dniAcamp = y.getDni(); 
									if (contabilizada.isSelected()) {
										//poner aqui singletonControllerAcampado.getInstance().modificarAcampado()
										y.setPagado(true); //estoy poniendo que si se contabiliza el ingreso, se actualiza el atributo pagado de acampado	
									}
								}else {
									dniAcamp = ""; 
								}
							}
								SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								fecha = sdf.format(new Date());
							SingletonControllerContabilidad.getInstance().modificarIngreso(cuenta.getSelectedItem().toString(), concepto.getText(), importe.getText(), fecha, acampado, dniAcamp,  contabilizada.isSelected(), getFrame());	
				}
				else JOptionPane.showMessageDialog(atras, "El importe tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(264, 265, 97, 25);
		getContentPane().add(boton_modificar);
		
		cuenta = new JComboBox<String>();
		cuenta.setBounds(178, 82, 116, 22);
		for(TIngresos cod: this.listaIngresos) {	
				cuenta.addItem(cod.getTipo());	
		}	
		
		cuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TIngresos cod: listaIngresos) {
					if (cod.getTipo().equals(cuenta.getSelectedItem().toString())) {
						if (cod.isContabilizada()) { //solo se pueden modificar el concepto y la cuenta de gasto
							contabilizada.setEnabled(false);
							importe.setEnabled(false); 
							acampadoNombre.setEnabled(false); 	
						
						}
						else {		
							if(!((String) cuenta.getSelectedItem()).matches("Ventas")) {	
								acampadoNombre.setEnabled(false); 	
								
							}else {
								acampadoNombre.setEnabled(true); 	
							}
							contabilizada.setEnabled(true);
							importe.setEnabled(true); 	
						}
						importeString = Integer.toString(cod.getImporte());
						importe.setText(importeString);
						acampadoNombre.setSelectedItem(cod.getNombreAcampado());
						concepto.setText(cod.getConcepto());
					}
				}
			}
		});
		getContentPane().add(cuenta);
			
		contabilizada = new JCheckBox("Marcar para contabilizar ingreso");
		contabilizada.setBounds(268, 34, 179, 25);
		contabilizada.setSelected(listaIngresos.get(0).isContabilizada());
		getContentPane().add(contabilizada);
		

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