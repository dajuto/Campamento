package gestoria.Presentacion;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class VistaModificarMantenimientoGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private JTextField coste;
	private String antiguoEmpleado;
	private JTextPane descripcion;
	private JComboBox<String> empleado;
	private JComboBox<String> codigo;
	private JComboBox<String> estado;
	private JComboBox<String> lugar;
	private String costeString;
	List<TMantenimiento> listaAverias;
	
	public VistaModificarMantenimientoGestor(JFrame frame) {
		setTitle("Modificar Averia");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,381);
		
		listaAverias = SingletonControllerGestoria.getInstance().getListaAverias();
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 296, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labmodificar = new JLabel("Modificar averia");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(25, 101, 97, 25);
		getContentPane().add(lblDescripcion);
		
		JLabel lblLugarr = new JLabel("Lugar:");
		lblLugarr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLugarr.setBounds(25, 169, 69, 25);
		getContentPane().add(lblLugarr);
		
		JLabel lblCoste = new JLabel("Coste:");
		lblCoste.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCoste.setBounds(25, 207, 69, 25);
		getContentPane().add(lblCoste);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 247, 97, 25);
		getContentPane().add(lblEmplead);
		
		empleado = new JComboBox<String>();
		empleado.setBounds(121, 249, 116, 22);
		antiguoEmpleado = listaAverias.get(0).getEmpleado();
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Mantenimiento")) {
				empleado.addItem(e.getNombre());
			}
		}
		empleado.setSelectedItem(listaAverias.get(0).getEmpleado());
		getContentPane().add(empleado);
		
		coste = new JTextField();
		coste.setBounds(121, 209, 116, 22);
		costeString = Integer.toString(listaAverias.get(0).getCoste());
		coste.setText(costeString);
		getContentPane().add(coste);
		coste.setColumns(10);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coste.getText().matches("[0-9]*")) {
					SingletonControllerGestoria.getInstance().modificarMantenimiento(codigo.getSelectedItem().toString(), descripcion.getText(), lugar.getSelectedItem().toString(), coste.getText(), empleado.getSelectedItem().toString(), estado.getSelectedItem().toString(), getFrame());
					SingletonControllerGestoria.getInstance().modificarEmpleadoMantenimiento(empleado.getSelectedItem().toString(), codigo.getSelectedItem().toString());
					if (!antiguoEmpleado.matches(empleado.getSelectedItem().toString())) {
						SingletonControllerGestoria.getInstance().modificarEmpleadoMantenimiento(antiguoEmpleado, codigo.getSelectedItem().toString());
					}
				}
				else JOptionPane.showMessageDialog(atras, "Formato de la fecha incorrecto \n DD/MM/AAAA", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(319, 191, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		codigo = new JComboBox<String>();
		codigo.setBounds(121, 63, 116, 22);
		for(TMantenimiento cod: this.listaAverias) {
			codigo.addItem(cod.getCodigo());
		}
		codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TMantenimiento cod: listaAverias) {
					if (cod.getCodigo().equals(codigo.getSelectedItem().toString())) {
						descripcion.setText(cod.getDescripcion());
						costeString = Integer.toString(cod.getCoste());
						coste.setText(costeString);
						lugar.setSelectedItem(cod.getLugar());
						empleado.setSelectedItem(cod.getEmpleado());
						estado.setSelectedItem(cod.getEstado());
						antiguoEmpleado = cod.getEmpleado();
					}
				}
			}
		});
		getContentPane().add(codigo);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEstado.setBounds(25, 286, 86, 25);
		getContentPane().add(lblEstado);
		
		estado = new JComboBox<String>();
		estado.setModel(new DefaultComboBoxModel(new String[] {"Reparado", "Sin reparar"}));
		estado.setBounds(121, 288, 116, 22);
		estado.setSelectedItem(listaAverias.get(0).getEstado());
		getContentPane().add(estado);
		
		lugar = new JComboBox<String>();
		lugar.setBounds(121, 171, 116, 22);
		for(TInstalacion i: SingletonControllerGestoria.getInstance().getListaInstalaciones()) {
			lugar.addItem(i.getNombre());
		}
		lugar.setSelectedItem(listaAverias.get(0).getLugar());
		getContentPane().add(lugar);
		
		descripcion = new JTextPane();
		descripcion.setBounds(121, 101, 227, 55);
		descripcion.setText(listaAverias.get(0).getDescripcion());
		getContentPane().add(descripcion);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaAverias = listaAverias;
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaAverias = listaAverias;
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaAverias = listaAverias;
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaAverias = listaAverias;
	}
}
