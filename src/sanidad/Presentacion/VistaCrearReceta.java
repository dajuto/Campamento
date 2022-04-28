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
import javax.swing.JTextField;

import acampados.Negocio.TAcampado;

import javax.swing.JComboBox;

public class VistaCrearReceta extends JFrame implements SanidadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFrame atras;
	private String nombreUsuario=SingletonControllerSanidad.getInstance().getNombreUsuarioSanidad();

	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_5;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	List<TMedico> listaMedicos;
	List<TAcampado> listaAcampados;
	
	public VistaCrearReceta(JFrame frame) {
		// TODO Auto-generated constructor stub
		setTitle("Menu Añadir Receta");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.setLocation(550,10);
		
		
		
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
				SingletonControllerSanidad.getInstance().anadirReceta(atras, lblNewLabel_5.getText(), textField_1.getText(), textField_2.getText(), comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString());
				
			}
		});
		boton_Aceptar.setBounds(15, 404, 499, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblNewLabel = new JLabel("Añadir Receta Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Codigo: ");
		lblNewLabel_1.setBounds(15, 93, 69, 20);
		getContentPane().add(lblNewLabel_1);
		
		int cod = 0;
		String c = null;
		for(TReceta e: SingletonControllerSanidad.getInstance().getListaRecetas()) {
			cod=e.getCodigo()+1;
			if(cod==10) {
				cod=1;
			}
			c=Integer.toString(cod);
		}
		
		lblNewLabel_5 = new JLabel(c);
		lblNewLabel_5.getText();
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(142, 93, 146, 20);
		getContentPane().add(lblNewLabel_5);
		
		
		
		
		JLabel lblMedicamento = new JLabel("Medicamento: ");
		lblMedicamento.setBounds(15, 129, 112, 20);
		getContentPane().add(lblMedicamento);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 126, 146, 26);
		getContentPane().add(textField_1);
		
		JLabel lblDosis = new JLabel("Dosis: ");
		lblDosis.setBounds(15, 165, 69, 20);
		getContentPane().add(lblDosis);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 162, 146, 26);
		getContentPane().add(textField_2);
		
		JLabel lblMedico = new JLabel("Medico: ");
		lblMedico.setBounds(15, 201, 69, 20);
		getContentPane().add(lblMedico);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(142, 200, 146, 22);
		for(TEmpleado e: SingletonControllerSanidad.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Medico")) {
				comboBox.addItem(e.getUsuario());
			}
		}
		getContentPane().add(comboBox);
		
		
		
		
		
		JLabel lblAcampado = new JLabel("Acampado: ");
		lblAcampado.setBounds(15, 237, 94, 20);
		getContentPane().add(lblAcampado);
		
	
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(142, 236, 146, 22);
		for(TAcampado e: SingletonControllerSanidad.getInstance().getListaAcampados()) {
			
				comboBox_1.addItem(e.getNombre());
			
		}
		getContentPane().add(comboBox_1);
	
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
