package sanidad.Presentacion;

import java.awt.Color;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import empleados.Negocio.TEmpleado;
import empleados.Negocio.TMedico;
import gestoria.Presentacion.SingletonControllerGestoria;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.TCita;
import sanidad.Negocio.TReceta;
import sanidad.Presentacion.SingletonControllerSanidad;

import javax.swing.JTextField;

import acampados.Negocio.TAcampado;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextPane;

public class VistaPedirCita extends JFrame implements SanidadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFrame atras;
	private String nombreUsuario=SingletonControllerSanidad.getInstance().getAcampado();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblNewLabel_2 ;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	List<TMedico> listaMedicos;
	List<TAcampado> listaAcampados;
	
	public VistaPedirCita(JFrame frame) {
		// TODO Auto-generated constructor stub
		setTitle("Menu Pedir Cita");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(376, 32, 138, 25);
		getContentPane().add(boton_Atras);
		

		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerSanidad.getInstance().pedirCita(atras, textField.getText(), textField_1.getText(), comboBox.getSelectedItem().toString(),lblNewLabel_2.getText());
				
			}
		});
		boton_Aceptar.setBounds(15, 404, 499, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblNewLabel = new JLabel("Añadir Cita Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Codigo: ");
		lblNewLabel_1.setBounds(15, 93, 69, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 90, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblMedicamento = new JLabel("Motivo: ");
		lblMedicamento.setBounds(15, 129, 112, 20);
		getContentPane().add(lblMedicamento);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 126, 146, 26);
		getContentPane().add(textField_1);
		
		
		JLabel lblMedico = new JLabel("Medico: ");
		lblMedico.setBounds(15, 165, 69, 20);
		getContentPane().add(lblMedico);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(142, 168, 146, 22);
		for(TEmpleado e: SingletonControllerSanidad.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Medico")) {
				comboBox.addItem(e.getNombre());
			}
		}
		getContentPane().add(comboBox);
		
		
		JLabel lblAcampado = new JLabel("Acampado: ");
		lblAcampado.setBounds(15, 201, 94, 20);
		getContentPane().add(lblAcampado);
		
		
		lblNewLabel_2 = new JLabel(this.nombreUsuario);
		lblNewLabel_2.getText();
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(142, 206, 146, 20);
		getContentPane().add(lblNewLabel_2);
		
		
	
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	private JFrame getFrame() {
		return this;
	}

	
	private void update(List<TMedico> listaMedicos,  String nombreUsuario) {
		this.listaMedicos = listaMedicos;
		//this.listaAcampados=listaAcampados;
		this.nombreUsuario = nombreUsuario;
	}
	
	

	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaMedicos,nombreUsuario);
	}

	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaMedicos,nombreUsuario);
	}

	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaMedicos,nombreUsuario);
	}

	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(listaMedicos,nombreUsuario);
	}
}