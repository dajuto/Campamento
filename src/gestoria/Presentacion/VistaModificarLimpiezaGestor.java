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

public class VistaModificarLimpiezaGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private JTextField hora_txt;
	private String antiguoEmpleado;
	private JComboBox<String> empleado;
	private JComboBox<String> codigo;
	private JComboBox<String> dia;
	private JComboBox<String> lugar;
	
	List<TLimpieza> listaLimpieza;
	
	public VistaModificarLimpiezaGestor(JFrame frame) {
		setTitle("Modificar horario de Limpieza");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		listaLimpieza = SingletonControllerGestoria.getInstance().getListaLimpieza();
		
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
		
		JLabel labmodificar = new JLabel("Modificar horario de limpieza");
		labmodificar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labmodificar.setBounds(25, 14, 341, 36);
		getContentPane().add(labmodificar);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLugar.setBounds(25, 101, 69, 25);
		getContentPane().add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFecha.setBounds(25, 137, 69, 25);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHora.setBounds(25, 175, 69, 25);
		getContentPane().add(lblHora);
		
		JLabel lblEmplead = new JLabel("Emplead@:");
		lblEmplead.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmplead.setBounds(25, 215, 97, 25);
		getContentPane().add(lblEmplead);
		
		empleado = new JComboBox<String>();
		empleado.setBounds(121, 217, 116, 22);
		antiguoEmpleado = listaLimpieza.get(0).getEmpleadoEncargado();
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Limpieza")) {
				empleado.addItem(e.getNombre());
			}
		}
		empleado.setSelectedItem(listaLimpieza.get(0).getEmpleadoEncargado());
		getContentPane().add(empleado);
		
		dia = new JComboBox<String>();
		dia.setBounds(121, 139, 116, 22);
		dia.addItem("Lunes");
		dia.addItem("Martes");
		dia.addItem("Miercoles");
		dia.addItem("Jueves");
		dia.addItem("Viernes");
		dia.addItem("Sabado");
		dia.setSelectedItem(listaLimpieza.get(0).getDia());
		getContentPane().add(dia);
		
		hora_txt = new JTextField();
		hora_txt.setBounds(121, 177, 116, 22);
		hora_txt.setText(listaLimpieza.get(0).getHora());
		getContentPane().add(hora_txt);
		hora_txt.setColumns(10);
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hora_txt.getText().matches("\\d{2}:\\d{2}")) {
					SingletonControllerGestoria.getInstance().modificarLimpieza(codigo.getSelectedItem().toString(), lugar.getSelectedItem().toString(), dia.getSelectedItem().toString(), hora_txt.getText(), empleado.getSelectedItem().toString(), getFrame());
					SingletonControllerGestoria.getInstance().modificarEmpleadoLimpieza(empleado.getSelectedItem().toString(), codigo.getSelectedItem().toString());
					if (!antiguoEmpleado.matches(empleado.getSelectedItem().toString())) {
						SingletonControllerGestoria.getInstance().modificarEmpleadoLimpieza(antiguoEmpleado, codigo.getSelectedItem().toString());
					}
				}
				else JOptionPane.showMessageDialog(atras, "Formato de la hora incorrecto \n HH:MM", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_modificar.setBounds(269, 129, 97, 25);
		getContentPane().add(boton_modificar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigo.setBounds(25, 63, 69, 25);
		getContentPane().add(lblCodigo);
		
		codigo = new JComboBox<String>();
		codigo.setBounds(121, 63, 116, 22);
		for(TLimpieza cod: this.listaLimpieza) {
			codigo.addItem(cod.getCodigo());
		}
		codigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(TLimpieza cod: listaLimpieza) {
					if (cod.getCodigo().equals(codigo.getSelectedItem().toString())) {
						dia.setSelectedItem(cod.getDia());
						hora_txt.setText(cod.getHora());
						lugar.setSelectedItem(cod.getLugar());
						empleado.setSelectedItem(cod.getEmpleadoEncargado());
						antiguoEmpleado = cod.getEmpleadoEncargado();
					}
				}
			}
		});
		getContentPane().add(codigo);
		
		lugar = new JComboBox<String>();
		lugar.setBounds(121, 103, 116, 22);
		for(TInstalacion i: SingletonControllerGestoria.getInstance().getListaInstalaciones()) {
			lugar.addItem(i.getNombre());
		}
		lugar.setSelectedItem(listaLimpieza.get(0).getLugar());
		getContentPane().add(lugar);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}

	@Override
	public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaLimpieza = listaLimpieza;
	}

	@Override
	public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaLimpieza = listaLimpieza;
		
	}

	@Override
	public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaLimpieza = listaLimpieza;
	}

	@Override
	public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
			List<TMantenimiento> listaAverias, List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
		this.listaLimpieza = listaLimpieza;
	}
	
	
}
