package Desktop;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;
import Entidades.AlumnoEnEjercicio;

public class XTableModelNotasAl extends AbstractTableModel {

ArrayList<AlumnoEnEjercicio> datasource;
	
	
	public ArrayList<AlumnoEnEjercicio> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<AlumnoEnEjercicio> datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column < 5) {
	            return false;
	        } else {
	       return true;
	        }
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
	
	public void setValueAt(Object value, int row, int col) {
        
		//datasource.get(row);
	
		
		switch (col) {
		case 0:
			break;
		case 1:
			datasource.get(row).getEjer().setNombre(value.toString());
			break;
		case 2:
			datasource.get(row).setNota_parcial(Float.parseFloat(value.toString()));
			break;
		case 3:
			datasource.get(row).getEjer().setPorcentaje(Integer.parseInt(value.toString()));
			break;
		case 4:
			datasource.get(row).getEjer().setCant_items(Integer.parseInt(value.toString()));
			break;
		case 5:
			datasource.get(row).setResultado(Integer.parseInt(value.toString()));
			break;
		
		default:
		
			break;
		}
		float valor= datasource.get(row).getResultado()*datasource.get(row).getEjer().getPorcentaje()/(datasource.get(row).getEjer().getCant_items()*10);
		datasource.get(row).setNota_parcial(valor);
      //  fireTableCellUpdated(row, col);
        fireTableRowsUpdated(0, datasource.size());
    }
	
	@Override
	public Object getValueAt(int arg0, int arg1) {
		AlumnoEnEjercicio alej= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=alej.getEjer().getCod_ejercicio();
			break;
		case 1:
			o=alej.getEjer().getNombre();
			break;
		case 2:
			o=alej.getNota_parcial();
			break;
		case 3:
			o=alej.getEjer().getPorcentaje();
			break;
		case 4:
			o=alej.getEjer().getCant_items();
			break;
		case 5:
			o=alej.getResultado();
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
			nom="Cod_ejercicio";
			break;
		case 1:
			nom="Nombre Ejercicio";
			break;
		case 2:
			nom="Nota parcial";
			break;
		case 3:
			nom="Peso Ejercicio";
			break;
		case 4:
			nom="Items Totales";
			break;	
		case 5:
			nom="Items correctos";
			break;
		
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}

	
	

