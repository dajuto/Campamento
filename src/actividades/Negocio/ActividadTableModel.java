package actividades.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ActividadTableModel extends AbstractTableModel implements ActividadObserver{

	private List<TActividad> list;
	private String[] columnNames = {"Id", "Nombre", "Instalacion", "Monitor"};
	
	public ActividadTableModel() {
		list = new ArrayList<TActividad>();
		SingletonServiAppActividad.getInstance().addObserver(this);
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onRegister(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEliminarActividad(List<TActividad> lista) {
		// TODO Auto-generated method stub
		
	}

}
