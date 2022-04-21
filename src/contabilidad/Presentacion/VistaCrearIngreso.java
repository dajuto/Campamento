package contabilidad.Presentacion;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleado;
import empleados.Presentacion.SingletonControllerEmpleado;
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

import acampados.Negocio.TAcampado;
import acampadosPresentacion.SingletonControllerAcampado;
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.Gastos;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

import javax.swing.DefaultComboBoxModel;

public class VistaCrearIngreso extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTextField concepto_txt;
	private JTextField fecha_txt;
	private JTextField importe_txt;
	private JComboBox<String> acampado_txt;
	private JComboBox<String> cuenta_txt;
	private String dniAcampado; 
	List<TIngresos> listaIngresos;
	List<TAcampado> listaAcampados;
	private JCheckBox contabilizada;
	private boolean boolContabilizada = false;
	
	public VistaCrearIngreso(JFrame frame) {
		setTitle("Añadir un Ingreso");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
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
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("A\u00F1adir Ingreso");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 17, 148, 36);
		getContentPane().add(labcrear);
		
		JLabel lblCodigo = new JLabel("Cuenta de Ingreso: ");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 148, 25);
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
		
		JLabel lblAcampado = new JLabel("Acampad@:");
		lblAcampado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAcampado.setBounds(25, 213, 97, 25);
		getContentPane().add(lblAcampado);
		
		cuenta_txt = new JComboBox<String>();
		cuenta_txt.setBounds(175, 66, 116, 22);
		getContentPane().add(cuenta_txt);
		for(TIngresos e: listaIngresos) {
			cuenta_txt.addItem(e.getTipo());
		}
		
		concepto_txt = new JTextField();
		concepto_txt.setBounds(110, 105, 116, 22);
		getContentPane().add(concepto_txt);
		concepto_txt.setColumns(10);
			
		fecha_txt = new JTextField();
		fecha_txt.setBounds(145, 179, 116, 22);
		getContentPane().add(fecha_txt);
		fecha_txt.setColumns(10);
		
		importe_txt = new JTextField();
		importe_txt.setBounds(110, 141, 116, 22);
		getContentPane().add(importe_txt);
		importe_txt.setColumns(10);	
		
		acampado_txt = new JComboBox<String>();
		acampado_txt.setBounds(121, 216, 116, 22);
		getContentPane().add(acampado_txt);
		for(TAcampado e: listaAcampados) {
			acampado_txt.addItem(e.getNombre());
		}
		
		contabilizada = new JCheckBox("Marca para contabilizar");
		contabilizada.setBounds(348, 177, 122, 25);
		getContentPane().add(contabilizada);
		
		cuenta_txt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!((String) cuenta_txt.getSelectedItem()).matches("Ventas")) {
					
					acampado_txt.setVisible(false);
					lblAcampado.setVisible(false);	
				}else {	
					acampado_txt.setVisible(true);
					lblAcampado.setVisible(true);	
				}	
			}
		});
			
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acampado = "";
				if (((String) cuenta_txt.getSelectedItem()).matches("Ventas")) {
					acampado = (String) acampado_txt.getSelectedItem();
				}
				
				if (fecha_txt.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
					
					if (importe_txt.getText().matches("[0-9]*")) {
						String cuenta = (String) cuenta_txt.getSelectedItem();
						
						//estoy cogiendo el dni del acampado seleccionado 
						for(TAcampado y: listaAcampados) {	
							if(acampado == (y.getNombre()+y.getApellidos())) {
								dniAcampado = y.getDni(); 
							}
						}
						if (contabilizada.isSelected()) {
							boolContabilizada = true;
						}
						SingletonControllerContabilidad.getInstance().añadirIngreso(cuenta, concepto_txt.getText(), importe_txt.getText(), fecha_txt.getText(), acampado, dniAcampado, boolContabilizada , getFrame());
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
