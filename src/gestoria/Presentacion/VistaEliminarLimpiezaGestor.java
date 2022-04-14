package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.TLimpieza;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;

public class VistaEliminarLimpiezaGestor extends JFrame implements LimpiezaObserver{
	private JFrame atras;
	private String nombreUsuario;
	public VistaEliminarLimpiezaGestor(JFrame frame) {
		setTitle("Eliminar horario limpieza");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel eliminar = new JLabel("Eliminar horario de limpieza");
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		eliminar.setBounds(25, 24, 330, 36);
		getContentPane().add(eliminar);
		
		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.setBounds(25, 112, 97, 25);
		getContentPane().add(boton_Eliminar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(25, 73, 239, 22);
		getContentPane().add(comboBox);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	@Override
	public void onRegister(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onModificarLimpieza(List<TLimpieza> listaA, List<TEmpleadoLimpieza> listaR, String nombreUsuario) {
		this.update(nombreUsuario);
	}

	@Override
	public void onActualizarListaEmpleadosLimpieza(List<TLimpieza> listaLimpieza,
			List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.update(nombreUsuario);
	}
}
