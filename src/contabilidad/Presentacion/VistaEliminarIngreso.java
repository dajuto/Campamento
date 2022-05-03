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
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;

public class VistaEliminarIngreso extends JFrame implements ContabilidadObserver{
	private JFrame atras;
	private JComboBox<String> FacturaElegido;
	List<TIngresos> listaIngresos;
	
	public VistaEliminarIngreso(JFrame frame) {
		setTitle("Eliminar Ingresos");
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
		
		JLabel eliminar = new JLabel("Seleccione un ingreso");
		eliminar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		eliminar.setBounds(25, 24, 330, 36);
		getContentPane().add(eliminar);
		
		FacturaElegido = new JComboBox<String>();
		FacturaElegido.setBounds(25, 73, 239, 22);
		listaIngresos = SingletonControllerContabilidad.getInstance().getListaIngresos();
		for(TIngresos cod: this.listaIngresos) {
			if(!cod.isContabilizada()) {  //solo se pueden eliminar los gastos que NO están contabilizados 
				FacturaElegido.addItem(cod.getnumeroFactura()); 
			}
		}
	
		getContentPane().add(FacturaElegido);
		
		
		JButton boton_Eliminar = new JButton("Eliminar");
		boton_Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				atras.setVisible(true);
				SingletonControllerContabilidad.getInstance().eliminarIngreso(frame, (String) FacturaElegido.getSelectedItem());
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
