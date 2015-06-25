/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;
import Datos.DBConexion_1;
import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.Ejercicio;
import Entidades.Examen;
import Entidades.Profesor;
import Entidades.AlumnoEnEjercicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static java.lang.System.out;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */


public class CatalogodeExamenes extends DBConexion_1{
    
    private ResultSet resu;
    
    public CatalogodeExamenes()
            {
          
            }
    
    public Examen listarExamen(int cod_carrera, int anio) throws Exception
    {
        try 
        {   this.Conectar();
            String vsql="SELECT * FROM examen where cod_carrera=? and (estado = 'sin generar' or estado='alumnos cargados')";
            PreparedStatement consulta= Cone.prepareStatement(vsql);
            consulta.setInt(1, cod_carrera);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx,tipoEx, anioEx, esEx, desEx);  
            this.Desconectar();
            return ex;
            
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
       
    }
    
     public void agregarExamen(Examen e, int cod_carrera) throws Exception
    {
        try 
        {	this.Conectar();
        	String actu = "INSERT INTO examen (tipo_examen, anio, estado, cod_carrera, descripcion) VALUES (?,?,?,?,?)";
        	PreparedStatement inse = Cone.prepareStatement(actu);
            inse.setString(1, e.getTipo_examen());
            inse.setInt(2, e.getAnio());
            inse.setString(3, e.getEstado());
            inse.setInt(4, cod_carrera);
            inse.setString(5, e.getDescripcion());
        	inse.executeUpdate();
            this.Desconectar();
            JOptionPane.showMessageDialog(null, "Se agrego el examen correctamente");
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
        
    }
     
     public Examen buscarExamen(String tipo_examen, int anio) throws Exception
    {
        try 
        {	this.Conectar();
            String consult = "SELECT * FROM examen WHERE tipo_examen = ? AND año=?";
            PreparedStatement consulta= Cone.prepareStatement(consult);
            consulta.setString(1, tipo_examen);
            consulta.setInt(2, anio);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(tipoEx, anioEx, esEx, desEx);   
            this.Desconectar();
            return ex;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
     
      public Examen buscaExamen(int cod_examen) throws Exception
    {
        try 
        {	this.Conectar();
	        PreparedStatement consulta= Cone.prepareStatement("SELECT * FROM examen WHERE cod_examen= ?");
	        consulta.setInt(1, cod_examen);
            resu = consulta.executeQuery();
            resu.first();
            int codEx = resu.getInt("cod_examen" );
            String tipoEx = resu.getString("tipo_examen");
            int anioEx = resu.getInt("anio");
            String esEx = resu.getString("estado");
            String desEx = resu.getString("descripcion");
            Examen ex = new Examen(codEx, tipoEx, anioEx, esEx, desEx);  
            this.Desconectar();
            return ex;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    }
      
      public void cambiarEstado(int cod_examen, String estado) throws Exception
      {
         try
         {    this.Conectar();
         	  PreparedStatement upd = Cone.prepareStatement("UPDATE examen SET estado= ? WHERE cod_examen= ?");
         	  upd.setString(1, estado);
         	  upd.setInt(2, cod_examen);
              upd.executeUpdate();    
              JOptionPane.showMessageDialog(null, "El examen ha sido"+estado, "Informacion", JOptionPane.INFORMATION_MESSAGE);
              this.Desconectar();
         }
         catch (Exception ex)
         {
             System.err.println("SQLException: " + ex.getMessage());
             
         }
        
          
      }

	public ArrayList<Alumno> getAllAlumnos(int cod_examen) {
		// TODO Auto-generated method stub
		 try
		 {
	        	this.Conectar();
	        	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	        	String cons="SELECT * FROM alumno_en_examen INNER JOIN alumno ON alumno_en_examen.dni=alumno.dni WHERE cod_examen = ? ORDER BY apellido,nombre";
	        	
	            PreparedStatement consulta= Cone.prepareStatement(cons);
	            consulta.setInt(1, cod_examen);
	             resu = consulta.executeQuery();
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
	             this.Desconectar();
	            return alumnos;

	        }
	        catch (Exception ex)
	        {
	            System.err.println("SQLException: " + ex.getMessage());
	            return null;            
	        }
		}
	
	public ArrayList<Examen> buscarExamenes(int cod_profesor) throws Exception
    {
        try 
        {    this.Conectar();
             PreparedStatement consulta= Cone.prepareStatement("select * from profesor_en_comision p INNER JOIN comision c ON c.cod_comision=p.cod_comision INNER JOIN examen e ON e.cod_examen=c.cod_examen WHERE p.cod_profesor=?;");
             consulta.setInt(1, cod_profesor);
             ArrayList<Examen> listaExamenes = new ArrayList<Examen>();
            
            resu = consulta.executeQuery();
            while(resu.next())
               {
                    
                    int cod_examen = resu.getInt("cod_examen" );
                    String tipo_examen = resu.getString("tipo_examen");
                    int anio = resu.getInt("anio");
                    String estado = resu.getString("estado");
                    String descripcion = resu.getString("descripcion");
                   
                    listaExamenes.add(new Examen(cod_examen, tipo_examen, anio, estado, descripcion,false));
                    
                    
                    
               }
            this.Desconectar();
            return listaExamenes;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
    
    }
	
	public ArrayList<Ejercicio> getAllEjercicios(int cod_examen) throws Exception
    {
        try 
        {   this.Conectar();
        	ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        	String lsql = "SELECT * FROM ejercicio WHERE cod_examen=?";
        	PreparedStatement consulta2= Cone.prepareStatement(lsql);
        	consulta2.setInt(1, cod_examen);
        	resu = consulta2.executeQuery();
        	while(resu.next())
             {
        		int cod_ejercicio= resu.getInt("cod_ejercicio");
        		String nombre = resu.getString("nombre");
        		String descripcion = resu.getString("descripcion");
        		int cant_items= resu.getInt("cant_items");
        		int porcentaje= resu.getInt("porcentaje");
        		Ejercicio ej = new Ejercicio(cod_ejercicio, nombre, descripcion, cant_items, porcentaje);
        		ejercicios.add(ej);
             }
        	this.Desconectar();
        	return ejercicios;
        	
            
        }
        
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
       
    }

	public ArrayList<AlumnoEnEjercicio> recuperarAlumnosEnEjercicio(int cod_ejercicio, int cod_examen) {
		try
		{
		this.Conectar();
		String vsql="SELECT * FROM ejercicio ej INNER JOIN alumno_en_ejercicio_examen alej ON ej.cod_examen=alej.cod_examen AND ej.cod_ejercicio=alej.cod_ejercicio INNER JOIN alumno al ON alej.dni=al.dni where ej.cod_examen=? AND ej.cod_ejercicio=?";
        PreparedStatement consulta= Cone.prepareStatement(vsql);
        consulta.setInt(1, cod_examen);
        consulta.setInt(2, cod_ejercicio);
        ArrayList<AlumnoEnEjercicio> alenej = new ArrayList<AlumnoEnEjercicio>();
        resu = consulta.executeQuery();
        while(resu.next())
        {      
            int dni = resu.getInt("al.dni");
            String apellido = resu.getString("al.apellido");
            String nombre =resu.getString("al.nombre");
            Alumno al = new Alumno(dni, nombre, apellido);
            int resultado = resu.getInt("alej.resultado");
            float notaparcial = resu.getFloat("alej.nota_parcial");
            alenej.add(new AlumnoEnEjercicio(al, resultado, notaparcial));
        }
        this.Desconectar();
		return alenej;
	}catch (Exception ex){
		System.err.println("SQLException: " + ex.getMessage());
        return null; 
		}
}
}