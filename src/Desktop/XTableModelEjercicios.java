package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Ejercicio;


public class XTableModelEjercicios extends AbstractTableModel {

	ArrayList<Ejercicio> datasource;
	
	
	public ArrayList<Ejercicio> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Ejercicio> datasource) {
		this.datasource = datasource;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}
    
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datasource.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		Ejercicio ejer= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=ejer.getNombre();
			break;
		case 1:
			o=ejer.getDescripcion();
			break;
		case 2:
			o=ejer.getCant_items();
			break;
		case 3:
			o=ejer.getPorcentaje();
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
			nom="Nombre";
			break;
		case 1:
			nom="Descripción";
			break;
		case 2:
			nom="Cantidad Items";
			break;
		case 3:
			nom="Porcentae";
			break;
		default:
			nom="";
			break;
		}
		return nom;
		
	}
	

}