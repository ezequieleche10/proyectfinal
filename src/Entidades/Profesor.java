/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;
import java.util.List;

import Datos.CatalogodeProfesores;

/**
 *
 * @author Lucia
 */
public class Profesor {
    
    private int cod_profesor;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasenia;
    private String fecha_nac;
    private List<Comision> comisiones;

    public Profesor(int cod_profesor, String nombre, String apellido) {
        this.cod_profesor = cod_profesor;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public Profesor(String nombre, String apellido, String fecha_Nac,String usuario, String contrasenia){
    	this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac= fecha_Nac;
        this.usuario= usuario;
        this.contrasenia=contrasenia;
    }
    
    

    public int getCod_profesor() {
        return cod_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public List<Comision> getComisiones() {
        return comisiones;
    }
    
    public void AgregarComision (Comision c) throws Exception {
        
       CatalogodeProfesores pd = new CatalogodeProfesores();
       pd.agregarProfesorEnComision(this.getCod_profesor(),c.getCod_comision());
        
    }
    public void AgregarProfesor() throws Exception{
    	CatalogodeProfesores prof= new CatalogodeProfesores();
    	prof.agregarProfesor(this.getNombre(),this.getApellido(),this.getFecha_nac(),this.usuario,this.contrasenia);
    }
    
    public String toString()
	{
		return this.getApellido() +" "+  this.getNombre();
	}
}
