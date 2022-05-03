package acampadosPresentacion;

import java.awt.Color;
import java.awt.Component;
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

public class VistaPedirCitaNuevoUsuario extends JFrame implements SanidadObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFrame atras;
	private String nombreUsuario;

	private JLabel lblNewLabel_3;
	JLabel lblNewLabel_2 ;
	JLabel lblNewLabel_5 ;
	JComboBox<String> comboBox;
	JComboBox<String> comboBox_1;
	List<TMedico> listaMedicos;
	List<TAcampado> listaAcampados;
	
	public VistaPedirCitaNuevoUsuario(JFrame frame, String motivo, String Acampado) {
		// TODO Auto-generated constructor stub
		this.nombreUsuario=Acampado;
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
				atras.setVisible(true);
				SingletonControllerSanidad.getInstance().pedirCita(atras, lblNewLabel_5.getText(), motivo, comboBox.getSelectedItem().toString(),Acampado);
				
				SingletonControllerSanidad.getInstance().modificarMedico(comboBox.getSelectedItem().toString(), lblNewLabel_5.getText());
			}
		});
		boton_Aceptar.setBounds(15, 404, 499, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblNewLabel = new JLabel("Pedir Cita Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("Codigo: ");
		lblNewLabel_1.setBounds(15, 93, 69, 20);
		getContentPane().add(lblNewLabel_1);
		
		
		int cod = 0;
		String c = null;
		for(TCita e: SingletonControllerSanidad.getInstance().getListaCitas()) {
			cod=e.getCodigo()+1;
			if(cod==20 ||cod>20) {
				cod=1;
			}
			c=Integer.toString(cod);
		}
		
		lblNewLabel_5 = new JLabel(c);
		lblNewLabel_5.getText();
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(142, 93, 146, 20);
		getContentPane().add(lblNewLabel_5);
		
		
		JLabel lblMedicamento = new JLabel("Motivo: ");
		lblMedicamento.setBounds(15, 129, 112, 20);
		getContentPane().add(lblMedicamento);
		

		lblNewLabel_3 = new JLabel(motivo);
		lblNewLabel_3.getText();
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(142, 129, 146, 20);
		getContentPane().add(lblNewLabel_3);
		
		
		JLabel lblMedico = new JLabel("Medico: ");
		lblMedico.setBounds(15, 165, 69, 20);
		getContentPane().add(lblMedico);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(142, 168, 146, 22);
		for(TEmpleado e: SingletonControllerSanidad.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Medico")) {
				comboBox.addItem(e.getUsuario());
			}
		}
		getContentPane().add(comboBox);
		
		
		JLabel lblAcampado = new JLabel("Acampado: ");
		lblAcampado.setBounds(15, 201, 94, 20);
		getContentPane().add(lblAcampado);
		
		
		lblNewLabel_2 = new JLabel(Acampado);
		lblNewLabel_2.getText();
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(142, 201, 146, 20);
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