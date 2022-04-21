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

public class VistaCrearLimpiezaGestor extends JFrame implements GestoriaObserver{
	private JFrame atras;
	private JComboBox<String> dia;
	private JTextField hora;
	private JTextField codigo;
	private JComboBox<String> empleado;
	private JComboBox<String> lugar;
	
	public VistaCrearLimpiezaGestor(JFrame frame) {
		setTitle("Crear horario de Limpieza");
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
		
		JLabel labcrear = new JLabel("Crea horario de limpieza nuevo");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 14, 330, 36);
		getContentPane().add(labcrear);
		
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
		for(TEmpleado e: SingletonControllerGestoria.getInstance().getListaEmpleados()) {
			if (e.getPuesto().matches("Empleado Limpieza")) {
				empleado.addItem(e.getNombre());
			}
		}
		getContentPane().add(empleado);
		
		dia = new JComboBox<String>();
		dia.setBounds(121, 139, 116, 22);
		dia.addItem("Lunes");
		dia.addItem("Martes");
		dia.addItem("Miercoles");
		dia.addItem("Jueves");
		dia.addItem("Viernes");
		dia.addItem("Sabado");
		getContentPane().add(dia);
		
		hora = new JTextField();
		hora.setBounds(121, 177, 116, 22);
		getContentPane().add(hora);
		hora.setColumns(10);
		
		JButton boton_Crear = new JButton("Crear");
		boton_Crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if (hora.getText().matches("\\d{2}:\\d{2}")) {
					SingletonControllerGestoria.getInstance().añadirLimpieza(codigo.getText(), lugar.getSelectedItem().toString(), dia.getSelectedItem().toString(), hora.getText(), empleado.getSelectedItem().toString(), getFrame());
					SingletonControllerGestoria.getInstance().modificarEmpleadoLimpieza(empleado.getSelectedItem().toString(), codigo.getText());
				}
				else JOptionPane.showMessageDialog(atras, "Formato de la hora incorrecto \n HH:MM", "Error", JOptionPane.ERROR_MESSAGE);			
			}
		});
		boton_Crear.setBounds(269, 129, 97, 25);
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
		lugar.setBounds(121, 103, 116, 22);
		for(TInstalacion i: SingletonControllerGestoria.getInstance().getListaInstalaciones()) {
			lugar.addItem(i.getNombre());
		}
		getContentPane().add(lugar);
		
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
