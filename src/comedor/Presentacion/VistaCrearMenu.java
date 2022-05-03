package comedor.Presentacion;

import java.awt.Color;
import java.awt.Font;
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
		setTitle("Crear Menu Campamento");
		this.atras=frame;
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.setLocation(550,10);
		
		
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(361, 404, 146, 25);
		getContentPane().add(boton_Atras);
		

		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerMenu.getInstance().crearMenu( textField_3.getText(), textField.getText(), textField_1.getText(), textField_2.getText(),atras);
				
			}
		});
		boton_Crear.setBounds(15, 404, 187, 25);
		getContentPane().add(boton_Crear);
		
		JLabel labcrear = new JLabel("Crear Menu");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 14, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lblDia = new JLabel("Día: ");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDia.setBounds(31, 93, 112, 20);
		getContentPane().add(lblDia);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 90, 146, 26);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Desayuno: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 151, 87, 20);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(142, 149, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblComida = new JLabel("Comida: ");
		lblComida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComida.setBounds(31, 211, 112, 20);
		getContentPane().add(lblComida);
		

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 208, 146, 26);
		getContentPane().add(textField_1);
		
		JLabel lblCena = new JLabel("Cena: ");
		lblCena.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu,dia);
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
