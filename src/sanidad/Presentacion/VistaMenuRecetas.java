package sanidad.Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import empleados.Negocio.TMedico;
import sanidad.Negocio.RecetasMedicoTableModel;
import sanidad.Negocio.SanidadObserver;
import sanidad.Negocio.TReceta;
import java.awt.Color;

public class VistaMenuRecetas extends JFrame implements SanidadObserver{
	
	private JFrame atras;
	private String nombreUsuario;
	private RecetasMedicoTableModel table;
	private JTable table_1;
	
	public VistaMenuRecetas(JFrame frame) {
		setTitle("Menu de Sanidad");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(551,501);
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atras");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(15, 403, 499, 25);
		getContentPane().add(boton_Atras);
		
		JLabel lblNewLabel = new JLabel("Lista Recetas Medico: " + nombreUsuario);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 261, 20);
		getContentPane().add(lblNewLabel);
		
		
		
		JButton btnCrearReceta = new JButton("Crear Receta");
		btnCrearReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerSanidad.getInstance().mostrarCrearReceta(getFrame());
			}
		});
		btnCrearReceta.setBounds(15, 358, 149, 29);
		getContentPane().add(btnCrearReceta);
		
		JButton btnConsultarRecetas = new JButton("Consultar Recetas");
		btnConsultarRecetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerSanidad.getInstance().mostrarConsultarRecetas(getFrame());
			}
		});
		btnConsultarRecetas.setBounds(165, 358, 198, 29);
		getContentPane().add(btnConsultarRecetas);
		
		JButton btnEliminarReceta = new JButton("Eliminar Receta");
		btnEliminarReceta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingletonControllerSanidad.getInstance().mostrarEliminarReceta(getFrame());
			}
		});
		btnEliminarReceta.setBounds(365, 358, 149, 29);
		getContentPane().add(btnEliminarReceta);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 96, 308, 196);
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable(new RecetasMedicoTableModel());
		panel.add(table_1, BorderLayout.CENTER);
		
		JPanel recetasView = createViewPanel(new JTable(new RecetasMedicoTableModel()), "Recetas Medico");
		recetasView.setPreferredSize(new Dimension(500, 400));
		getContentPane().add(recetasView);
		
	}
	private JFrame getFrame() {
		return this;
	}
	
	 private JPanel createViewPanel(JComponent c, String title) {
			JPanel p = new JPanel( new BorderLayout() );
			p.add(new JScrollPane(c));
			return p;
		}
	
	private void update(String nombreUsuario) {
		// TODO Auto-generated method stub
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCrearReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onConsultarReceta(List<TReceta> listaRecetas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onEliminarCita(List<TReceta> listaCitas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConsultarCita(List<TReceta> listaCitas, List<TMedico> listaMedicos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}
}
