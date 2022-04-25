package contabilidad.Presentacion;

import javax.swing.DefaultComboBoxModel;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import contabilidad.Negocio.TGastos;

import javax.swing.JCheckBox;

public class VistaModificarGasto extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto;
	private JTextField importe;
	private JComboBox<String> empleadoNombre;
	private String importeString;
	private JCheckBox contabilizada;
	List<TGastos> listaGastos; 
	List<TEmpleado> listaEmpleados;
	private String empleado; 
	private String fecha;
	private JComboBox<String> FacturaElegido;
	private String numeroFactura; 
	private String cuenta; 

	
	public VistaModificarGasto(JFrame frame) {
		setTitle("Modificar gasto");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,350);
		
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
		boton_Atras.setBounds(373, 265, 97, 25);
		getContentPane().add(boton_Atras);
		
			
		JLabel labmodificar = new JLabel("Seleccione un gasto");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblImporte.setBounds(25, 174, 84, 25);
		getContentPane().add(lblImporte);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 222, 97, 25);
		getContentPane().add(lblEmplead);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConcepto.setBounds(25, 127, 84, 25);
		getContentPane().add(lblConcepto);
			
		concepto = new JTextField();
		concepto.setBounds(135, 129, 116, 26);
		concepto.setText(listaGastos.get(0).getConcepto()); //concepto
		getContentPane().add(concepto);
		concepto.setColumns(10);
		
		importe = new JTextField();
		importe.setBounds(135, 178, 116, 22);
		importeString = Integer.toString(listaGastos.get(0).getImporte());
		importe.setText(importeString);
		getContentPane().add(importe);
		importe.setColumns(10);
		
		empleadoNombre =  new JComboBox<String>();
		empleadoNombre.setBounds(135, 225, 116, 22);
		empleadoNombre.setSelectedItem(listaGastos.get(0).getNombre());
		getContentPane().add(empleadoNombre);
		for(TEmpleado e: listaEmpleados) {
			empleadoNombre.addItem(e.getNombre());
		}
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (importe.getText().matches("[0-9]*")) {
                          if(!cuenta.matches("Sueldos y Salarios")) {	
							empleado = "";	
						}else {
						     empleado = (String) empleadoNombre.getSelectedItem();
						}
                          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							fecha = sdf.format(new Date());
						SingletonControllerContabilidad.getInstance().modificarGasto(cuenta, concepto.getText(), importe.getText(), fecha, empleado,  contabilizada.isSelected(), numeroFactura,  getFrame());
						
				}
				else JOptionPane.showMessageDialog(atras, "El importe tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(264, 265, 97, 25);
		getContentPane().add(boton_modificar);
		
		FacturaElegido = new JComboBox<String>();
		FacturaElegido.setBounds(159, 85, 106, 22);
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		for(TGastos cod: this.listaGastos) { 
				FacturaElegido.addItem(cod.getnumeroFactura()); 
		}
	
		getContentPane().add(FacturaElegido);
	
		
		FacturaElegido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TGastos cod: listaGastos) {
					if (cod.getnumeroFactura().equals(FacturaElegido.getSelectedItem().toString())) {
						cuenta = cod.getTipo();
						
						if (cod.isContabilizada()) { //solo se pueden modificar el concepto y la cuenta de gasto
							contabilizada.setEnabled(false);
							importe.setEnabled(false); 
							empleadoNombre.setEnabled(false); 	
						}
						else {
							if(!(cuenta.matches("Sueldos y Salarios"))) {	
								empleadoNombre.setEnabled(false); 			
							}else {
								empleadoNombre.setEnabled(true); 	
							}
							
			         		contabilizada.setEnabled(true);
							importe.setEnabled(true); 
						}				
						importeString = Integer.toString(cod.getImporte());
						importe.setText(importeString);
						empleadoNombre.setSelectedItem(cod.getNombre()); 
						concepto.setText(cod.getConcepto());
						numeroFactura = cod.getnumeroFactura();
						cuenta = cod.getTipo();
						
						
					}
				}
			}
		});
			
		contabilizada = new JCheckBox("Marcar para contabilizar gasto");
		contabilizada.setBounds(283, 224, 165, 25);
		contabilizada.setSelected(listaGastos.get(0).isContabilizada());
		getContentPane().add(contabilizada);
		
		JLabel lblNumeroFactura = new JLabel("Numero Factura");
		lblNumeroFactura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroFactura.setBounds(25, 82, 127, 25);
		getContentPane().add(lblNumeroFactura);
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






