package comedor.Presentacion;

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
import comedor.Presentacion.SingletonControllerMenu;
import comedor.Negocio.MenuObserver;
import comedor.Negocio.TMenu;
import javax.swing.JTextField;

import acampados.Negocio.TAcampado;

import javax.swing.JComboBox;

public class VistaCrearMenu extends JFrame implements MenuObserver{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private JFrame atras;
	private String dia;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	List<TMenu> listaMenu;
	
	public VistaCrearMenu(JFrame frame) {
		// TODO Auto-generated constructor stub
		setTitle("Añadir Menu");
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
		boton_Atras.setBounds(361, 404, 146, 25);
		getContentPane().add(boton_Atras);
		

		JButton boton_Aceptar = new JButton("Aceptar");
		boton_Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().crearMenu( textField_3.getText(), textField.getText(), textField_1.getText(), textField_2.getText(),atras);
				
			}
		});
		boton_Aceptar.setBounds(15, 404, 187, 25);
		getContentPane().add(boton_Aceptar);
		
		JLabel lblNewLabel = new JLabel("Añadir Menu ");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(15, 11, 261, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDia = new JLabel("Dia: ");
		lblDia.setBounds(31, 93, 112, 20);
		getContentPane().add(lblDia);
		

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 90, 146, 26);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Desayuno: ");
		lblNewLabel_1.setBounds(31, 152, 69, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 149, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblComida = new JLabel("Comida: ");
		lblComida.setBounds(31, 211, 112, 20);
		getContentPane().add(lblComida);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 208, 146, 26);
		getContentPane().add(textField_1);
		
		JLabel lblCena = new JLabel("Cena: ");
		lblCena.setBounds(31, 271, 69, 20);
		getContentPane().add(lblCena);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(142, 268, 146, 26);
		getContentPane().add(textField_2);
		
		
	
		setVisible(true);
	}
	
	@SuppressWarnings("unused")
	private JFrame getFrame() {
		return this;
	}

	
	private void update(List<TMenu> listaMenu,  String dia) {
		this.listaMenu = listaMenu;
		//this.listaAcampados=listaAcampados;
		this.dia = dia;
	}
	
	

	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu,dia);
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu,dia);
	}

	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu,dia);
	}
}
