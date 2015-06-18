/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Alumno;
import Entidades.NotaExamenAlumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogodeAlumnos extends DBConexion_1{
    
    private ResultSet resu;
    
    public ArrayList<Alumno> buscarAlumnos() throws Exception
    {
        try 
        {
             ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
             getStmt();
             resu = stmt.executeQuery("SELECT * FROM alumno");
             while(resu.next())
               {
                    int dniAl = resu.getInt("dni" );
                    String nomAl = resu.getString("nombre");
                    String apeAl = resu.getString("apellido");
                    String mailAl = resu.getString("mail");
                    String ingdiAl = resu.getString("ingreso_directo");
                    String tuelAl = resu.getString("turno_eleccion");
                    Alumno al = new Alumno(dniAl, nomAl, apeAl, mailAl, tuelAl, ingdiAl); 
                    alumnos.add(al); 
                    
               }
            return alumnos;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
    
    public void agregarAlumnos(ArrayList<Alumno> alumnos) throws Exception
    {
        try 
        {
        	/*
            String insert="INSERT INTO alumno (dni, nombre, apellido, mail, ingreso_directo, turno_eleccion)VALUES(?,?,?,?,?,?)";
            PreparedStatement ins= conexion.prepareStatement(insert);
            for (int i =0; i<alumnos.size(); i++)
            {
            int dni = alumnos.get(i).getDni();
            String nombre = alumnos.get(i).getNombre();
            String apellido = alumnos.get(i).getApellido();
            String mail = alumnos.get(i).getMail();
            String ingDire = alumnos.get(i).getIngreso_directo();
            String turnElec = alumnos.get(i).getTurno_eleccion();
            ins.setInt(1,dni);
            ins.setString(2,nombre);
            ins.setString(3,apellido);
            ins.setString(4,mail);
            ins.setString(5,ingDire);
            ins.setString(6,turnElec);
            ins.executeUpdate();
            
            
             }*/
        	
        	for (int i =0; i<alumnos.size(); i++)
            {
        		
        	
               getStmt();
               int dni= alumnos.get(i).getDni();
               String n1=alumnos.get(i).getApellido();
               String n2=alumnos.get(i).getNombre();
               String n3=alumnos.get(i).getMail();
               String n4=alumnos.get(i).getIngreso_directo();
               String n5=alumnos.get(i).getTurno_eleccion();
               stmt.executeUpdate("INSERT INTO alumno (dni, nombre, apellido, mail, ingreso_directo, turno_eleccion) VALUES ('"+dni+"','"+n2+"','"+n1+"','"+n3+"','"+n4+"','"+n5+"')");
               
               
                
            }
            
            JOptionPane.showMessageDialog(null, "Los alumnos se agregaron satisfactoriamente!!!");
            this.Desconectar();
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
                        
        }
    }
    
}
