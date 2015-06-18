/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.Profesor;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucia
 */
public class CatalogodeProfesores  extends DBConexion_1 {
    private ResultSet resu;
    
    public void agregaraComision(ArrayList<Profesor> profes, int cod_comision) throws Exception
    {
        try 
        {   this.Conectar();
        	for (int i =0; i<profes.size(); i++)
            {
        		PreparedStatement insert= Cone.prepareStatement("INSERT INTO profesor_en_comision(cod_profesor,cod_comision) VALUES(?,?)");
        	    int codPr= profes.get(i).getCod_profesor();
        		insert.setInt(1, codPr);
        		insert.setInt(2, cod_comision);
                insert.executeUpdate();
               }
            
            JOptionPane.showMessageDialog(null, "Comisión creada satisfactoriamente!!!");
            this.Desconectar(); 
        	
        	
        	
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());            
        }
    }
    
    
     public ArrayList<Profesor> getAllProfesores() throws Exception
    {
        try 
        {    this.Conectar();
             PreparedStatement consulta= Cone.prepareStatement("SELECT * FROM profesor");
             ArrayList<Profesor> profes = new ArrayList<Profesor>();
            
            resu = consulta.executeQuery();
            while(resu.next())
               {
                    
                    int cod_profesor = resu.getInt("cod_profesor" );
                    String nomPr = resu.getString("nombre");
                    String apePr = resu.getString("apellido");
                    
                    profes.add(new Profesor(cod_profesor,nomPr,apePr));
                    
                    
                    
               }
            this.Desconectar();
            return profes;
        }
        catch (Exception ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            return null;            
        }
        finally{this.Desconectar();}
    }
     public void agregarProfesor(String nombre, String apellido, String fec_Nac, String usu, String password) throws Exception
     {
         try 
         {	 this.Conectar();
             String insert="INSERT INTO profesor(nombre,apellido,fecha_Nac,usuario,clave) VALUES(?,?,?,?,?)";
             PreparedStatement ins= Cone.prepareStatement(insert);
             ins.setString(1, nombre);
             ins.setString(2, apellido);
             ins.setString(3,fec_Nac);
             ins.setString(4, usu);
             ins.setString(5,password);
             ins.executeUpdate();
             JOptionPane.showMessageDialog(null,"Se agregó correctamente");
             this.Desconectar();
         }
         catch (Exception ex)
         {
             System.err.println("SQLException: " + ex.getMessage()); 
             JOptionPane.showMessageDialog(null, "Verifica la conexion a la BD");
         }
         
         
     }
}
