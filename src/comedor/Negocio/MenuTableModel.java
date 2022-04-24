package comedor.negocio;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

public class MenuTableModel extends AbstractTableModel implements MenuObserver{

	private List<TMenu> list;
	private String[] columnNames = {"Dia", "Desayuno", "Comida", "Cena"};
	
	public MenuTableModel() {
		list = new ArrayList<TMenu>();
		SingletonServiAppMenu.getInstance().addObserver(this);
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
		switch(columnIndex) {
		case 0: return list.get(rowIndex).getDia(); 
		case 1: return list.get(rowIndex).getDesayuno();
		case 2:	return list.get(rowIndex).getComida();
		case 3: return list.get(rowIndex).getCena();
		default: return null;
		}
	}
	
	private void update(List<TMenu> lista) {
		this.list = lista;
		this.fireTableDataChanged();
	}

	@Override
	public void onCrearMenu(List<TMenu> lista) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}

	@Override
	public void onEliminarMenu(List<TMenu> lista) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
	
	@Override
	public void onModificarMenu(List<TMenu> lista) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
	
	@Override
	public void onConsultarMenu(List<TMenu> lista) {
		// TODO Auto-generated method stub
		this.update(listaMenu);
	}
}
