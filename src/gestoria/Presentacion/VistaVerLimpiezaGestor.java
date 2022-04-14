package gestoria.Presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;

import empleados.Negocio.TEmpleadoLimpieza;
import gestoria.Negocio.LimpiezaObserver;
import gestoria.Negocio.LimpiezaTableModel;
import gestoria.Negocio.TLimpieza;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JComponent;
import javax.swing.JTable;

public class VistaVerLimpiezaGestor extends JFrame implements LimpiezaObserver{
	private JFrame atras;
	private String nombreUsuario;
	private JTable table;
	public VistaVerLimpiezaGestor(JFrame frame) {
		setTitle("Lista horarios limpieza");
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
		
		JLabel labcrear = new JLabel("Lista horarios limpieza");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		labcrear.setBounds(25, 24, 330, 36);
		getContentPane().add(labcrear);
		
		JPanel p2 = createViewPanel(new JTable(new LimpiezaTableModel()), "Aulas gestor");
		p2.setBounds(35, 73, 416, 126);
		getContentPane().add(p2);
		
		setVisible(true);
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
