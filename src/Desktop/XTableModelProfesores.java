package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Profesor;

public class XTableModelProfesores extends AbstractTableModel {

	ArrayList<Profesor> datasource;
	
	
	public ArrayList<Profesor> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Profesor> datasource) {
		this.datasource = datasource;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}
    
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datasource.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		Profesor prof= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=prof.getCod_profesor();
			break;
		case 1:
			o=prof.getApellido();
			break;
		case 2:
			o=prof.getNombre();
			break;
		
		default:
			o=null;
			break;
		}
		return o;
	}
	public String getColumnName( int column)
	{
		String nom="";
		switch (column) {
		case 0:
			nom="Codigo";
			break;
		case 1:
			nom="Apellido";
			break;
		case 2:
			nom="Nombre";
			break;
		
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}