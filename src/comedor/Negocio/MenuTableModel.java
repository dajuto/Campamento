package comedor.Negocio;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

public class MenuTableModel extends AbstractTableModel implements MenuObserver{

	private static final long serialVersionUID = 1L;
	private List<TMenu> listMenu;
	private String[] columnNames = {"Dia", "Desayuno", "Comida", "Cena"};
	
	public MenuTableModel() {
		listMenu = new ArrayList<TMenu>();
		SingletonServiAppMenu.getInstance().addObserver(this);
	}
	
	
	@Override
	public int getRowCount() {
		return listMenu.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnNames[columnIndex];
	}
	

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return listMenu.get(rowIndex).getDia();
		}
		else if(columnIndex == 1) {
			return listMenu.get(rowIndex).getDesayuno();
		}
		else if(columnIndex == 2) {
			return listMenu.get(rowIndex).getComida();
		}
		else {
			return listMenu.get(rowIndex).getCena();
		}
	}
	
	private void update(List<TMenu> listaMenu) {
		this.listMenu = listaMenu;
		this.fireTableDataChanged();
	}

	@Override
	public void onRegister(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
	
	@Override
	public void onCrearMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}

	@Override
	public void onEliminarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
	
	
	@Override
	public void onConsultarMenu(List<TMenu> listaMenu) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
}
