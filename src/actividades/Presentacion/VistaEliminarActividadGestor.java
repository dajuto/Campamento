package actividades.Presentacion;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.TActividad;

public class VistaEliminarActividadGestor extends JFrame implements ActividadObserver{

	private String nombreUsuario;
	private Frame ventanaAnterior;
	private JButton aceptar;
	private JButton atras;
	
	private JLabel ingresaIdActividad;
	private JComboBox<TActividad> idActividad;
	List<TActividad> listaActividades;
	
	public VistaEliminarActividadGestor(Frame ventanaListaAverias) {
		setTitle("Eliminar actividad");
		this.ventanaAnterior = ventanaListaAverias;
		
		SingletonControllerActividad.getInstance().addObserver(this);
		this.nombreUsuario = nombreUsuario;
		
		
		this.atras = new JButton("Atras");
		this.aceptar = new JButton("Aceptar");
		
		this.idActividad = new JComboBox<TActividad>();
		
		this.ingresaIdActividad = new JLabel("Codigo de la actividad que desea eliminar: ");
		
		initGUI();
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		mainPanel.add(new JLabel("Eliminar actividad Gestor: " + this.nombreUsuario), BorderLayout.PAGE_START);
		
		JPanel p = new JPanel(new GridLayout(1, 2));
		p.add(this.ingresaIdActividad);
		for(TActividad ta: this.listaActividades) {
			idActividad.addItem(ta);
		}
		p.add(idActividad);
		
		mainPanel.add(p);
		
		JPanel a = new JPanel(new GridLayout(2, 1));
		a.add(atras);
		this.atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//ventanaAnterior.setVisible(true);
			}
		});
		a.add(aceptar);
		this.aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerActividad.getInstance().eliminarActividad(ventanaAnterior, ((TActividad) idActividad.getSelectedItem()).getId());
			}
		});
		mainPanel.add(a, BorderLayout.PAGE_END);
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

			@Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}

        });
		
		this.pack();
		this.setVisible(true);
	}
	
	private void quit() {
    	int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1); // el 1 es para q x defecto la opcion senalada sea NO
        if (option == 0) {
            System.exit(0);
        }
	}

	private void update (List<TActividad>lista) {
		this.listaActividades=lista;
	}
	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);

	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(lista);

	}

}

