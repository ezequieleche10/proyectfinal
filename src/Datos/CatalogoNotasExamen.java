/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.NotaExamenAlumno;
import Entidades.Alumno;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogoNotasExamen extends DBConexion_1 {
    
     private ResultSet resu;
     public ArrayList<NotaExamenAlumno> listarNotaExamenAlumno(int cod_examen) throws Exception
    {
        try 
        {
             ArrayList<NotaExamenAlumno> notasExamenesAlumnos = new ArrayList<NotaExamenAlumno>();
            getStmt();
            resu = stmt.executeQuery("SELECT * FROM alumno_en_examen INNER JOIN alumno ON alumno_en_examen.dni=alumno.dni WHERE cod_examen = '"+cod_examen+"'");
            while(resu.next())
               {
                    float nota = resu.getFloat("nota");
                    String condicion = resu.getString("estado");
                    int dniAl = resu.getInt("dni" );
                    String nomAl = resu.getString("nombre");
                    String apeAl = resu.getString("apellido");
                    String mailAl = resu.getString("mail");
                    String tuelAl = resu.getString("turno_eleccion");
                    String indiAl = resu.getString("ingreso_directo");
                    Alumno al = new Alumno(dniAl, nomAl, apeAl,  mailAl, tuelAl, indiAl);
                    NotaExamenAlumno nea= new NotaExamenAlumno(nota,condicion,al);
                    
                    notasExamenesAlumnos.add(nea); 
               }
            return notasExamenesAlumnos;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
     
     
      public void agregarAlumnos(ArrayList<NotaExamenAlumno> listaNotas, int cod_examen) throws Exception
    {
        try 
        {
            
            /*String insert="INSERT INTO alumno_en_examen(dni,cod_examen,estado,nota)VALUES(?,?,?,?)";
            PreparedStatement ins= conexion.prepareStatement(insert);
            for (int i =0; i<listaNotas.size(); i++)
            {
            int dni = listaNotas.get(i).getAlumno().getDni();
            String estado = listaNotas.get(i).getCondicion();
            float nota = listaNotas.get(i).getNota();
            ins.setInt(1,dni);
            ins.setInt(2,cod_examen );
            ins.setString(3,estado);
            ins.setFloat(4, nota);
            ins.executeUpdate();
        	}*/
    
        	for (int i =0; i<listaNotas.size(); i++)
            {
        		
        	
               getStmt();
               int dni= listaNotas.get(i).getAlumno().getDni();
               String estado = listaNotas.get(i).getCondicion();
               float nota = listaNotas.get(i).getNota();
               stmt.executeUpdate("INSERT INTO alumno_en_examen (dni, cod_examen, estado, nota) VALUES ('"+dni+"','"+cod_examen+"','"+estado+"','"+nota+"')");
               }
            
            JOptionPane.showMessageDialog(null, "Los alumnos se agregaron satisfactoriamente al examen!");
            
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
                        
        }
    }
    
    
}
