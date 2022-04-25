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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import actividades.Negocio.ActividadObserver;
import actividades.Negocio.TActividad;

public class VistaActividadGestor extends JFrame implements ActividadObserver {

	private JButton listaActividades;
	private JButton atras;
	private Frame ventanaAnterior;
	private String nombreUsuario;

	public VistaActividadGestor(Frame frame) {
		
		setTitle("Actividades");
		this.ventanaAnterior = frame;
		SingletonControllerActividad.getInstance().addObserver(this);
		this.listaActividades = new JButton("Lista Mis Actividades");
		this.atras = new JButton("Atras");
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		mainPanel.add(new JLabel("Actividad Gestor Actividades: "), BorderLayout.PAGE_START);
		JPanel p = new JPanel(new GridLayout(2, 1));
		p.add(listaActividades);
		this.listaActividades.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SingletonControllerActividad.getInstance().mostrarListaActividadesGestor(getFrame());
			}
		});
		mainPanel.add(p);
		
		JPanel a = new JPanel(new GridLayout(1, 1));
		a.add(atras);
		this.atras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ventanaAnterior.setVisible(true);
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
	
	private Frame getFrame() {
		return this;
	}
	
	/*private void initGUI() {
		
	}*/
    private void quit() {
    	int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1); // el 1 es para q x defecto la opcion senalada sea NO
        if (option == 0) {
            System.exit(0);
        }
	}
    
    private void update (String nombreUsuario) {
    	this.nombreUsuario=nombreUsuario;
    }

	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		this.update(nombreUsuario);

	}
}


