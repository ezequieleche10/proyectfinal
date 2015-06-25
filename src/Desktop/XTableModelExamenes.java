package Desktop;



import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import Entidades.Alumno;
import Entidades.Examen;

//lucas  

public class XTableModelExamenes extends AbstractTableModel {

ArrayList<Examen> datasource;
	
	
	public ArrayList<Examen> getDatasource() {
		return datasource;
	}

	public void setDatasource(ArrayList<Examen> datasource) {
		this.datasource = datasource;
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		//Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (column < 2) {
            return false;
        } else {
            return true;
        }
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
	
	 public Class getColumnClass(int c) {
	        return getValueAt(0, c).getClass();
	    }
	 
	 
	 public void setValueAt(Object value, int row, int col) {
		
		 for(int i=0; i<datasource.size();++i){
			 datasource.get(i).setBandera(false);
			// fireTableCellUpdated(row, col);
		 }
		 fireTableRowsUpdated(0, datasource.size());
		 //a ese le pone true.
		 datasource.get(row).setBandera(Boolean.parseBoolean(value.toString()));
		 fireTableCellUpdated(row, col);
		 //ahora a todos los otros ponerle false para que no elija mas de uno
		// ver para validar que no seleccione mas de uno
	 }			

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Examen ex= datasource.get(arg0);
		Object o;
		switch (arg1) {
		case 0:
			o=ex.getCod_examen();
			break;
		case 1:
			o=ex.getTipo_examen();
			break;
		case 2:
			o=ex.getAnio();
			break;
		case 3:
			//ver lo del radiobutton
			o= ex.getBandera(); //new Boolean(false);
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
			nom="Código Examen";
			break;
		case 1:
			nom="Tipo Examen";
			break;
		case 2:
			nom="Año";
			break;
		case 3:
			nom="Seleccionar";
			break;
		
		default:
			nom="";
			break;
		}
		return nom;
		
	}

}