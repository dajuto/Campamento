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
import sanidad.Negocio.TCita;
import sanidad.Negocio.TReceta;
import java.awt.Color;

public class VistaMenuRecetas extends JFrame implements SanidadObserver{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario=SingletonControllerSanidad.getInstance().getNombreUsuarioSanidad();
	private RecetasMedicoTableModel table;
	private JTable table_1;
	
	public VistaMenuRecetas(JFrame frame) {
		setTitle("Menu de Recetas");
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
		
		
		
		JPanel recetasView = createViewPanel(new JTable(new RecetasMedicoTableModel()), "Recetas Medico");
		recetasView.setBounds(10, 40, 500, 300);
		getContentPane().add(recetasView);
		
		this.setVisible(true);
	}
	private JFrame getFrame() {
		return this;
	}
	
	 private JPanel createViewPanel(JComponent c, String title) {
			JPanel p = new JPanel( new BorderLayout() );
			p.add(new JScrollPane(c), BorderLayout.CENTER);
			return p;
		}
	
	private void update(String nombreUsuario) {
		// TODO Auto-generated method stub
		this.nombreUsuario = nombreUsuario;
	}


	@Override
	public void onRegister(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	@Override
	public void onEliminar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	@Override
	public void onConsultar(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
	@Override
	public void onCrear(List<TReceta> listaRecetas, List<TCita> listaCitas, List<TMedico> listaMedicos,
			String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}
}
