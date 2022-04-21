package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleado;
import empleados.Negocio.TEmpleadoLimpieza;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JTextPane;

public class VistaCrearMantenimientoGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private JTextField coste;
	private JTextField codigo;
	private JComboBox<String> empleado;
	private JComboBox<String> lugar;
	private JTextPane descripcion;
	
	public VistaCrearMantenimientoGestor(JFrame frame) {
		setTitle("Crear nueva averia");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,348);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 263, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("Crea una nueva averia");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 14, 330, 36);
		getContentPane().add(labcrear);
		
		JLabel lbldescripcion = new JLabel("Descripcion:");
		lbldescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbldescripcion.setBounds(25, 101, 97, 25);
		getContentPane().add(lbldescripcion);
		
		JLabel lbllugar = new JLabel("Lugar:");
		lbllugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbllugar.setBounds(25, 172, 69, 25);
		getContentPane().add(lbllugar);
		
		JLabel lblCoste = new JLabel("Coste:");
		lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCoste.setBounds(25, 210, 69, 25);
		getContentPane().add(lblCoste);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 250, 97, 25);
		getContentPane().add(lblEmplead);
		
		empleado = new JComboBox<String>();
		empleado.setBounds(121, 252, 116, 22);
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Mantenimiento")) {
				empleado.addItem(e.getNombre());
			}
		}
		getContentPane().add(empleado);
		
		coste = new JTextField();
		coste.setBounds(121, 212, 116, 22);
		getContentPane().add(coste);
		coste.setColumns(10);
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coste.getText().matches("[0-9]*")) {
					SingletonControllerGestoria.getInstance().añadirMantenimiento(codigo.getText(), descripcion.getText(), lugar.getSelectedItem().toString(), coste.getText(), empleado.getSelectedItem().toString(), getFrame());
					SingletonControllerGestoria.getInstance().modificarEmpleadoMantenimiento(empleado.getSelectedItem().toString(), codigo.getText());
				}
				else JOptionPane.showMessageDialog(atras, "El coste tiene que ser un numero", "Error", JOptionPane.ERROR_MESSAGE);			
				}
		});
		boton_Crear.setBounds(314, 191, 97, 25);
		getContentPane().add(boton_Crear);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(121, 65, 116, 22);
		getContentPane().add(codigo);
		
		lugar = new JComboBox<String>();
		lugar.setBounds(121, 174, 116, 22);
		for(TInstalacion i: SingletonControllerGestoria.getInstance().getListaInstalaciones()) {
			lugar.addItem(i.getNombre());
		}
		getContentPane().add(lugar);
		
		 descripcion = new JTextPane();
		descripcion.setBounds(121, 104, 227, 55);
		getContentPane().add(descripcion);
		
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
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
