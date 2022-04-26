package contabilidad.Presentacion;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import contabilidad.Negocio.ContabilidadObserver;
import contabilidad.Negocio.TGastos;
import contabilidad.Negocio.TIngresos;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;



public class VistaRendimientoContabilidad extends JFrame implements ContabilidadObserver{
	
	private static final long serialVersionUID = 1L;
	private JFrame atras;
	private String nombreUsuario;
	private JTextField gastos_txt;
	private JTextField ingresos_txt;
	private JTextField rend_txt;
	List<TIngresos> listaIngresos; 
	List<TGastos> listaGastos; 
	private int TotalGastos; 
	private int TotalIngresos; 
	private int Rendimiento; 
    private String tot;
    private String gas; 
    private String ingr; 
    
	
	public VistaRendimientoContabilidad(JFrame frame) {
		setTitle("Rendimiento del ejercicio");
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		setSize(500,300);
		
		listaIngresos = SingletonControllerContabilidad.getInstance().getListaIngresos();
		listaGastos = SingletonControllerContabilidad.getInstance().getListaGastos();
		
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
		
		
		JLabel g = new JLabel("Total Gastos");
		g.setFont(new Font("Times New Roman", Font.BOLD, 24));
		g.setBounds(26, 105, 138, 36);
		getContentPane().add(g);
		
		gastos_txt = new JTextField();
		gastos_txt.setBounds(189, 105, 120, 36);
		getContentPane().add(gastos_txt);
		gastos_txt.setColumns(10);
		
		JLabel ing = new JLabel("Total Ingresos");
		ing.setFont(new Font("Times New Roman", Font.BOLD, 24));
		ing.setBounds(26, 41, 153, 36);
		getContentPane().add(ing);
		
		ingresos_txt = new JTextField();
		ingresos_txt.setBounds(188, 41, 121, 36);
		getContentPane().add(ingresos_txt);
		ingresos_txt.setColumns(10);
		ingresos_txt.setEditable(false);
		
		JLabel ren = new JLabel("Rendimiento Ejercicio");
		ren.setFont(new Font("Times New Roman", Font.BOLD, 24));
		ren.setBounds(26, 165, 240, 36);
		getContentPane().add(ren);
		
		rend_txt = new JTextField();
		rend_txt.setBounds(275, 171, 105, 34);
		getContentPane().add(rend_txt);
		rend_txt.setColumns(10);
		
		for(TIngresos cod: listaIngresos) {
			TotalIngresos += cod.getImporte();  
		}
		
        for(TGastos cod: listaGastos) {	
			TotalGastos += cod.getImporte();  
		}
		
        Rendimiento = TotalIngresos - TotalGastos; 
         
        tot = Integer.toString(Rendimiento);
        rend_txt.setText(tot);
        
        ingr = Integer.toString(TotalIngresos);
        ingresos_txt.setText(ingr);
        
        gas = Integer.toString(TotalGastos);
        gastos_txt.setText(gas);
        
		this.setVisible(true);
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void update(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	   //actualizar lista gastos e ingresos con for
	}
	
	@Override
	public void onRegister(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario); 	
	}

	@Override
	public void onCreate(List<TGastos> listaGastos, List<TIngresos> listaIngresos, String nombreUsuario) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);	
	}

	@Override
	public void onActualizar(List<TGastos> listaGastos, List<TIngresos> listaIngresos,String nombreUsuario) {	
			this.update(nombreUsuario);	
	}
}
