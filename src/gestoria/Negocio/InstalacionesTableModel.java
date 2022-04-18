package gestoria.Negocio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import empleados.Negocio.TEmpleadoGestoria;


public class InstalacionesTableModel extends AbstractTableModel implements GestoriaObserver {
	private static final long serialVersionUID = 1L;
	
		private List<TInstalacion> list;
		private String[] columnNames = {"Codigo", "Nombre", "Superficie","Precio", "Pagado", "Actividades"};
		
		public InstalacionesTableModel() {
			list = new ArrayList<TInstalacion>();
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
			case 1:	return list.get(rowIndex).getNombre();
			case 2: return list.get(rowIndex).getSuperficie();
			case 3: return list.get(rowIndex).getPrecio();
			case 4: return list.get(rowIndex).isPagado();
			case 5: return list.get(rowIndex).isPuedeActividades();
			default: return null;
			}
		}
		
		private void update(List<TInstalacion> lista) {
			this.list = lista;
			this.fireTableDataChanged();
		}

		@Override
		public void onRegister(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
			this.update(listaInstalaciones);
		}

		@Override
		public void onCreate(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
			this.update(listaInstalaciones);
		}

		@Override
		public void onEliminar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
			this.update(listaInstalaciones);
		}

		@Override
		public void onModificar(List<TLimpieza> listaLimpieza, List<TInstalacion> listaInstalaciones,
				List<TEmpleadoGestoria> listaEmpleadosLimpieza, String nombreUsuario) {
			this.update(listaInstalaciones);
		}


		
}
