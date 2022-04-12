package launcher;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SuperVista extends JFrame implements ActionListener{
	
	private JButton subsEstudiante;
	private JButton subsEmpleado;
	
	public SuperVista() {
		super("Gestion de un colegio mayor");
		this.subsEmpleado = new JButton("Empleados");
		this.subsEstudiante = new JButton("Estudiantes");
		initGUI();
	}
	
	private JFrame getFrame() {
		return this;
	}
	
	private void initGUI() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setContentPane(mainPanel);
		mainPanel.add(new JLabel("GesCol"), BorderLayout.PAGE_START);
		JPanel p = new JPanel(new GridLayout(1, 2));
		p.add(this.subsEmpleado);
		this.subsEmpleado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonSuperControlador.getInstance().mostrarGeneralEmpleado(getFrame());
				setVisible(false);
			}
		});
		p.add(this.subsEstudiante);
		this.subsEstudiante.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SingletonSuperControlador.getInstance().mostrarGeneralAcampado(getFrame());
				setVisible(false);
			}
		});
		mainPanel.add(p, BorderLayout.CENTER);
		
		
		
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
		setMinimumSize(new Dimension(600,125));
		this.setVisible(true);
	}
	
    private void quit() {
    	int option = JOptionPane.showOptionDialog(this, "Are you sure you want to quit?", "quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 1); // el 1 es para q x defecto la opcion senalada sea NO
        if (option == 0) {
            System.exit(0);
        }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	/*private JPanel createViewPanel(JComponent c, String title) {
		JPanel p = new JPanel( new BorderLayout() );
		p.add(new JScrollPane(c));
		return p;
	}*/
}
