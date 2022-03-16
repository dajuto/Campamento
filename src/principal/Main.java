package principal;

import java.awt.EventQueue;

import vista.Bienvenidos;
import vista.empleados;

public class Main {
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenidos frame = new Bienvenidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
}
