package gestoria.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import empleados.Negocio.TEmpleadoLimpieza;


public class LimpiezaTableModel extends AbstractTableModel implements LimpiezaObserver {
	private static final long serialVersionUID = 1L;
	
		private List<TLimpieza> list;
		private String[] columnNames = {"Codigo", "Lugar", "Fecha","Hora", "Empleado"};
		
		public LimpiezaTableModel() {
			list = new ArrayList<TLimpieza>();
			SingletonServiAppGestoria.getInstance().addObserver(this);
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return list.size();
		}
		
		@Override
		public String getColumnName(int columnIndex) {
			return columnNames[columnIndex];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			switch(columnIndex) {
			case 0: return list.get(rowIndex).getCodigo();
			case 1:	return list.get(rowIndex).getLugar();
			case 2: return list.get(rowIndex).getFecha();
			case 3: return list.get(rowIndex).getHora();
			case 4: return list.get(rowIndex).getEmpleadoEncargado();
			default: return null;
			}
		}
		
		private void update(List<TLimpieza> lista) {
			this.list = lista;
			this.fireTableDataChanged();
		}

		@Override
		public void onRegister(List<TLimpieza> listaLimpieza, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			this.update(listaLimpieza);
		}

		@Override
		public void onCreateLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			this.update(listaLimpieza);
		}

		@Override
		public void onEliminarLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			this.update(listaLimpieza);
		}

		@Override
		public void onModificarLimpieza(List<TLimpieza> listaLimpieza, List<TEmpleadoLimpieza> listaEmpleadosLimpieza,
				String nombreUsuario) {
			this.update(listaLimpieza);
		}

		@Override
		public void onActualizarListaEmpleadosLimpieza(List<TLimpieza> listaLimpieza,
				List<TEmpleadoLimpieza> listaEmpleadosLimpieza, String nombreUsuario) {
			this.update(listaLimpieza);
		}


		
}
