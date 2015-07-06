package Desktop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Entidades.Alumno;
import jxl.Cell;
//import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {
 private String inputFile;
 
 public void setInputFile(String inputFile) {
  this.inputFile = inputFile;
 }
 
 public ArrayList<Alumno> read() throws IOException{
  File inputWorkbook = new File(inputFile);
  Workbook w;
 try {
  w = Workbook.getWorkbook(inputWorkbook);
  // Get the first sheet
  Sheet sheet = w.getSheet(0);
  ArrayList<Alumno> alumnos= new ArrayList<Alumno>();
  //loop over first 10 column and lines
  	
  for (int i=1;i<sheet.getRows(); i++){
	
	Alumno al = new Alumno();
	
	  for(int j= 0;j<sheet.getColumns();j++)   {
    Cell cell = sheet.getCell(j,i);
    		switch(j){
    			case 0: al.setDni(Integer.parseInt(cell.getContents()));break;
    			case 1: al.setApellido(cell.getContents());break;
    			case 2: al.setNombre(cell.getContents()); break;
    			case 3: al.setMail(cell.getContents()); break;
    			case 4:al.setIngreso_directo(cell.getContents());break;
    			case 5: al.setTurno_eleccion(cell.getContents());break;
    			case 6: al.setNombre_Carrera(cell.getContents()); break;
    }}
    alumnos.add(al);
    }
    
    
	  /*CellType type = cell.getType();
    if(type == CellType.LABEL) {
     System.out.println("I got a label " + cell.getContents());
    }
    if(type == CellType.NUMBER) {
     System.out.println("I got a number " + cell.getContents());
    }
   }*/
  //}
  return alumnos;
  
  } catch(BiffException e) {
   e.printStackTrace();
   return null;
 }
 


 }
 
 /*
 public static void main(String[] args) throws IOException {
  ReadExcel test= new ReadExcel();
  test.setInputFile("C:\\exceli.xls");
  test.read();
 }
 */
 
}