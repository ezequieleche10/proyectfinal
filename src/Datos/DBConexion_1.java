/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
/**
 *
 * @author Lucas
 */
public class DBConexion_1 {
	String connectionUrl="jdbc:mysql://localhost:3306/cossettini";
	String connectionDriver="com.mysql.jdbc.Driver";
    String connectionUser = "root";
	String connectionPassword = "";
    protected Connection conexion;
    protected Statement stmt;
   
  
      public Connection Conectar()
        {
    	try {
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    			Connection conexion = DriverManager.getConnection(connectionUrl,connectionUser,connectionPassword);
				stmt=conexion.createStatement();
			
		} catch (SQLException e) {
			conexion=null;
		} catch (Exception e) {
			conexion=null;
		}
		return conexion;
	    }
        
    
    public DBConexion_1()
    {
        this.Conectar();
    }
    
   // private String getConnectUrl()
    //{
        //return url;
    //}
    
    public void Desconectar () throws SQLException
    {
        stmt.close();
        conexion.close();
    }
    
    public Statement getStmt()
    {
        return this.stmt;
    }
}