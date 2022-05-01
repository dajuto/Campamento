package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import actividades.Negocio.AcampadoActTableModel;
import actividades.Negocio.ActividadObserver;
import actividades.Negocio.ActividadTableModel;
import actividades.Negocio.TActividad;

public class VistaActividadesAcampado extends JFrame implements ActividadObserver{

	private String nombreUsuario;
	private JFrame atras;
	
	public VistaActividadesAcampado(JFrame frame) {
		setTitle("Lista de Actividades");

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
		
		JPanel recetasView = createViewPanel(new JTable(new AcampadoActTableModel()), "Lista de Actividades");
		recetasView.setBounds(10, 40, 500, 300);
		getContentPane().add(recetasView);
		
		this.setVisible(true);
		
	}
	
	 private JPanel createViewPanel(JComponent c, String title) {
			JPanel p = new JPanel( new BorderLayout() );
			p.add(new JScrollPane(c));
			return p;
	}
	
	 private void update (String nombreUsuario) {
	   	this.nombreUsuario=nombreUsuario;
	 }
	 @Override
	 public void onRegister(List<TActividad> lista) {
			this.update(nombreUsuario);
	}

		@Override
		public void onCreateActividad(List<TActividad> lista) {
			this.update(nombreUsuario);
	}

		@Override
		public void onEliminarActividad(List<TActividad> lista) {
			this.update(nombreUsuario);
	}


}
