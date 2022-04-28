package contabilidad.Presentacion;


import javax.swing.JButton;
import javax.swing.JFrame;
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

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.IngresosTableModel;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

public class VistaVerIngresos extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private String nombreUsuario;
	public VistaVerIngresos(JFrame frame) {
		setTitle("Lista de Ingresos Campamento");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(624,384);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(437, 289, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel labcrear = new JLabel("Lista de Ingresos");
		labcrear.setFont(new Font("Times New Roman", Font.BOLD, 22));
		labcrear.setBounds(25, 24, 330, 36);
		getContentPane().add(labcrear);
		
		JPanel p2 = createViewPanel(new JTable(new IngresosTableModel()), "Ingresos campamento");
		p2.setBounds(35, 73, 533, 183);
		getContentPane().add(p2);
		
		setVisible(true);
	}
	
	private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		JScrollPane scrollPane = new JScrollPane(c);
		p.add(scrollPane, BorderLayout.CENTER);
		return p;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActualizar(List<TGastos> listaLimpieza, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}		
}
