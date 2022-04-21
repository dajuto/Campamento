package contabilidad.Presentacion;


import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JComboBox;
//import javax.swing.JTextField;

import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

//import javax.swing.JTable;

public class VistaEliminarGasto extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private JComboBox<String> codElegido;
	List<TGastos> listaGastos;
	
	public VistaEliminarGasto(JFrame frame) {
		setTitle("Eliminar Gastos");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		this.atras = frame;
		
		JButton boton_Atras = new JButton("Atrás");
		boton_Atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				atras.setVisible(true);
			}
		});
		boton_Atras.setBounds(373, 215, 97, 25);
		getContentPane().add(boton_Atras);
		
		JLabel eliminar = new JLabel("Seleccione un gasto");
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		eliminar.setBounds(25, 24, 330, 36);
		getContentPane().add(eliminar);
		
		codElegido = new JComboBox<String>();
		codElegido.setBounds(25, 73, 239, 22);
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		for(TGastos cod: this.listaGastos) {
			codElegido.addItem(cod.getConcepto());  //poner en el concepto un código 
		}
		getContentPane().add(codElegido);
		
		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				atras.setVisible(true);
				SingletonControllerContabilidad.getInstance().eliminarGasto(frame, (String) codElegido.getSelectedItem());
			}
		});
		boton_Eliminar.setBounds(25, 112, 97, 25);
		getContentPane().add(boton_Eliminar);
		
		setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActualizar(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		
	}

	
	

}
