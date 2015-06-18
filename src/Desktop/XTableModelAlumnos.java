package Desktop;



import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;



public class XTableModelAlumnos extends AbstractTableModel {

ArrayList<Alumno> datasource;
	
	
	public ArrayList<Alumno> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Alumno> datasource) {
		this.datasource = datasource;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datasource.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Alumno al= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=al.getDni();
			break;
		case 1:
			o=al.getApellido();
			break;
		case 2:
			o=al.getNombre();
			break;
		case 3:
			o=al.getMail();
			break;
		case 4:
			o=al.getIngreso_directo();
			break;
		case 5:
			o=al.getTurno_eleccion();
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
			nom="Dni";
			break;
		case 1:
			nom="Apellido";
			break;
		case 2:
			nom="Nombre";
			break;
		case 3:
			nom="Mail";
			break;
		case 4:
			nom="Ingreso Directo";
		    break;
		case 5:
			nom="Turno elección";
			break;
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}

	
	

